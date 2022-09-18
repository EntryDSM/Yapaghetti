package kr.hs.entrydsm.yapaghetti.global.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.main-origin}")
    private String mainOrigin;

    @Value("${cors.user-origin}")
    private String userOrigin;

    @Value("${cors.teacher-origin}")
    private String teacherOrigin;

    @Value("${cors.company-origin}")
    private String companyOrigin;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("http://localhost:3000", "http://localhost:3001",
                        "http://localhost:3002", "http://localhost:3003",
                        mainOrigin, userOrigin, teacherOrigin, companyOrigin);
    }
}
