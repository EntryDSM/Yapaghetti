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

    private final Long accessExp;

    private final Long refreshExp;

    public JwtProperties(String secret, Long accessExp, Long refreshExp) {
        this.secret = Base64.getEncoder().encodeToString(secret.getBytes());
        this.accessExp = accessExp * 1000;
        this.refreshExp = refreshExp * 1000;
    }

}
