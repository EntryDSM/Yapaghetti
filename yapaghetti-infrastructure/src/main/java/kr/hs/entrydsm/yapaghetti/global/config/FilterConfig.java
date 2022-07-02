package kr.hs.entrydsm.yapaghetti.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.hs.entrydsm.yapaghetti.global.error.filter.GlobalErrorFilter;
import kr.hs.entrydsm.yapaghetti.global.security.jwt.JwtTokenFilter;
import kr.hs.entrydsm.yapaghetti.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final ObjectMapper objectMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(HttpSecurity builder) {
        builder.addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(new GlobalErrorFilter(objectMapper), JwtTokenFilter.class);
    }
}
