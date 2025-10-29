package Exersises.DearDiaryAPI.src.main.java.csc280.roeback.lia.DearDiary;


import java.beans.BeanProperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DearDiaryApplication {
	public static void main(String [] args){
		SpringApplication.run(DearDiaryApplication.class, args);
	}
	@Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override public void addCorsMappings(CorsRegistry registry){
                //registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
                registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("*");
 
            }
        };
    }
}
