package br.com.itilh.bdpedidos.sistemaspedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class SistemaspedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaspedidosApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer forwardToIndex() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController( "/" )
                        .setViewName("forward:/app/index.html");
            }
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**");
			}


        };
    }

}
