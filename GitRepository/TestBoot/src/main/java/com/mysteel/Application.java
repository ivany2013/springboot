package com.mysteel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mysteel.interceptor.LoginInterceptor;


@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter{
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
        application.setShowBanner(false);
        application.run(args);
	}

	
	@Bean
    public LoginInterceptor getLoginInterceptor(){
        return new LoginInterceptor();
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor())
        .addPathPatterns("/users");
    }
	
	
	
	
}
