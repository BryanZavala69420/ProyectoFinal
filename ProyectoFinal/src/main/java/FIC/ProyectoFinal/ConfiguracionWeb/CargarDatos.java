package FIC.ProyectoFinal.ConfiguracionWeb;




import FIC.ProyectoFinal.Anuncios.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import FIC.ProyectoFinal.Repositorio.UsuarioRepositorio;

@Configuration
public class CargarDatos{
    @Bean
    public CommandLineRunner loadData(UsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder) {
        return args -> {
            if (usuarioRepositorio.findByUsername("Admin").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setUsername("Admin");
                admin.setPassword(passwordEncoder.encode("1234"));
                admin.setRol("User");
                usuarioRepositorio.save(admin);
            }
        };
    }
}
