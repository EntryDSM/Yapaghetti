package kr.hs.entrydsm.yapaghetti.global.property;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("jwt")
@Getter
@AllArgsConstructor
public class JwtProperties {

    private final String secret;

    private final String accessExp;

    private final String refreshExp;

}
