package kr.hs.entrydsm.yapaghetti.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import kr.hs.entrydsm.yapaghetti.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private static final String STUDENT = UserRole.STUDENT.name();
    private static final String TEACHER = UserRole.TEACHER.name();
    private static final String COMPANY = UserRole.COMPANY.name();
    private static final String MOU = UserRole.MOU.name();
    private static final String NON_MOU = UserRole.NON_MOU.name();

    private final ObjectMapper objectMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors();

        http
                .authorizeRequests()
                .antMatchers("/users/auth").permitAll()
                .antMatchers("/users/first-password").hasAnyRole(STUDENT, TEACHER, MOU)
                .antMatchers(HttpMethod.POST, "/images").hasAnyRole(STUDENT, TEACHER, MOU)
                .anyRequest().authenticated()
                .and().apply(new FilterConfig(objectMapper, jwtTokenProvider));

        return http.build();
    }
}