package com.placementcellCodes.CollegePlacementcell.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // Marks this as a configuration class
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Apply CORS settings to all paths (all controllers)
        registry.addMapping("/**")  // This applies CORS to all routes in your application
            .allowedOrigins("http://localhost:5174")  // Frontend address (React app)
            .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allowed HTTP methods
            .allowedHeaders("*")  // Allow all headers
            .allowCredentials(true);  // Allow cookies or authentication tokens
    }
}
