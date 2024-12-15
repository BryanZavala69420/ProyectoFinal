package FIC.ProyectoFinal.ConfiguracionWeb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import FIC.ProyectoFinal.Servicios.Usuariodetalles;

@Configuration
@EnableWebSecurity
public class SeguridadWeb {

    private final Usuariodetalles usuariodetalles;

    // Constructor para inyectar el servicio personalizado
    public SeguridadWeb(Usuariodetalles usuariodetalles) {
        this.usuariodetalles = usuariodetalles;
    }

    // Configuración principal del SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((request) -> request
                .requestMatchers("/Login", "/logout").permitAll() // Permitir acceso sin autenticación
                .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
            )
            .formLogin((form) -> form
                .loginPage("/Login") // Página personalizada para el login
                .defaultSuccessUrl("/anuncios", true) // Redirigir a /anuncios tras inicio exitoso
                .failureUrl("/Login?error=true") // Redirigir a /Login con un mensaje de error
                .permitAll()
            )
            .logout((logout) -> logout
                .logoutSuccessUrl("/Login?logout=true") // Redirigir tras cerrar sesión
                .permitAll()
            )
            .rememberMe((rememberMe) -> rememberMe
                .key("uniqueAndSecret") // Llave secreta única para generar tokens seguros
                .tokenValiditySeconds(14 * 24 * 60 * 60) // Tiempo en segundos (14 días)
                .userDetailsService(usuariodetalles) // Servicio para cargar los detalles del usuario
            );
    
        return http.build();
    }
    

    // Codificador de contraseñas (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración del AuthenticationManager
    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder)
            throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(usuariodetalles) // Usar tu servicio personalizado
                .passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }
}
