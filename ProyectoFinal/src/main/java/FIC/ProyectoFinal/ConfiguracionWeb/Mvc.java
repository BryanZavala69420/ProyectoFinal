package FIC.ProyectoFinal.ConfiguracionWeb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Mvc implements WebMvcConfigurer{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/Home").setViewName("Home");
        registry.addViewController("/").setViewName("Home");
        registry.addViewController("/new").setViewName("new");
        registry.addViewController("/Login").setViewName("Login");
    }

}
