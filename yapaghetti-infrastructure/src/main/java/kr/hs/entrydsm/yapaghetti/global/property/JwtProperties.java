package kr.hs.entrydsm.yapaghetti.global.property;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Base64;

@ConstructorBinding
@ConfigurationProperties("jwt")
@Getter
public class JwtProperties {

    private final String secret;

    private final String accessExp;

    private final String refreshExp;

    public JwtProperties(String secret, String accessExp, String refreshExp) {
        this.secret = Base64.getEncoder().encodeToString(secret.getBytes());
        this.accessExp = accessExp;
        this.refreshExp = refreshExp;
    }

}
