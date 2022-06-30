package kr.hs.entrydsm.yapaghetti.global.property;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("aws.ses")
@Getter
@AllArgsConstructor
public class AwsSesProperties {

    private final String accessKey;

    private final String secretKey;

    private final String region;

}
