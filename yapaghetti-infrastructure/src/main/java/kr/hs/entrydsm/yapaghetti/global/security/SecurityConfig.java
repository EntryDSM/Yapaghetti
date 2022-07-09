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

                // users
                .antMatchers(HttpMethod.POST, "/users/auth").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users/first-password").hasAnyRole(STUDENT, TEACHER, MOU)
                .antMatchers(HttpMethod.PATCH, "/users/information").hasAnyRole(STUDENT, TEACHER, MOU)

                // teachers
                .antMatchers(HttpMethod.POST, "/teachers/feedback/{student-id}").hasRole(TEACHER)
                .antMatchers(HttpMethod.DELETE, "/teachers/student/{student-id}").hasRole(TEACHER)
                .antMatchers(HttpMethod.DELETE, "/teachers/company/{company-id}").hasRole(TEACHER)

                // tags
                .antMatchers(HttpMethod.POST, "/tags").hasRole(TEACHER)
                .antMatchers(HttpMethod.DELETE, "/tags/{tag-id}").hasRole(TEACHER)
                .antMatchers(HttpMethod.POST, "/tags/my-skill").hasRole(STUDENT)
                .antMatchers(HttpMethod.POST, "/tags/major").hasRole(STUDENT)
                .antMatchers(HttpMethod.GET, "/tags").hasAnyRole(STUDENT, TEACHER)

                // images
                .antMatchers(HttpMethod.POST, "/images").hasAnyRole(STUDENT, TEACHER, MOU)

                // documents
                .antMatchers(HttpMethod.POST, "/documents").hasRole(STUDENT)
                .antMatchers(HttpMethod.PATCH, "/documents/{document-id}").hasRole(STUDENT)
                .antMatchers(HttpMethod.PATCH, "/documents/cancel/{document-id}").hasRole(STUDENT)
                .antMatchers(HttpMethod.GET, "/documents/{document-id}").hasRole(STUDENT)
                .antMatchers(HttpMethod.DELETE, "/documents/{document-id}").hasRole(STUDENT)
                .antMatchers(HttpMethod.POST, "/documents/copy").hasRole(STUDENT)
                .antMatchers(HttpMethod.POST, "/documents/{document-id}").hasRole(STUDENT)
                .antMatchers(HttpMethod.GET, "/documents/public/{document-id}").hasAnyRole(STUDENT, TEACHER, MOU)
                .antMatchers(HttpMethod.DELETE, "/documents/public/{student-id}").hasRole(TEACHER)
                .antMatchers(HttpMethod.GET, "/documents/protected-url").hasRole(STUDENT)
                .antMatchers(HttpMethod.GET, "/documents/stay/{document-id}").hasAnyRole(STUDENT, TEACHER)
                .antMatchers(HttpMethod.PATCH, "/documents/stay").hasRole(STUDENT)
                .antMatchers(HttpMethod.GET, "/documents/list").hasRole(STUDENT)

                // students
                .antMatchers(HttpMethod.GET, "/students").hasRole(STUDENT)
                .antMatchers(HttpMethod.PATCH, "/students/feedback/{sequence}").hasRole(STUDENT)

                // companies
                .antMatchers(HttpMethod.PATCH, "/companies/name").hasAnyRole(MOU)
                .antMatchers(HttpMethod.GET, "/companies/students").hasAnyRole(MOU, NON_MOU)
                .anyRequest().authenticated()
                .and().apply(new FilterConfig(objectMapper, jwtTokenProvider));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}