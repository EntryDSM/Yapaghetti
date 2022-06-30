package kr.hs.entrydsm.yapaghetti.global.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("jwt")
@Getter
@RequiredArgsConstructor
public class JwtProperties {

    private final String secret;

    private final String accessExp;

    private final String refreshExp;

}
