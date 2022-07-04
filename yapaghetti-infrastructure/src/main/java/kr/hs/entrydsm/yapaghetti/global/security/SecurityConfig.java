package kr.hs.entrydsm.yapaghetti.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import kr.hs.entrydsm.yapaghetti.global.config.FilterConfig;
import kr.hs.entrydsm.yapaghetti.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private static final String STUDENT = UserRole.STUDENT.name();
    private static final String TEACHER = UserRole.TEACHER.name();
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

                .antMatchers(HttpMethod.POST, "/users/auth").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users/first-password").hasAnyRole(STUDENT, TEACHER, MOU)

                .antMatchers(HttpMethod.POST, "/documents").hasRole(STUDENT)
                .antMatchers(HttpMethod.GET, "/documents/public/{document-id}").hasAnyRole(STUDENT, TEACHER, MOU)

                .anyRequest().authenticated()
                .and().apply(new FilterConfig(objectMapper, jwtTokenProvider));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}