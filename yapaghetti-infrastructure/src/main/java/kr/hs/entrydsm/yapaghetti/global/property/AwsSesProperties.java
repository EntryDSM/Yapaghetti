package kr.hs.entrydsm.yapaghetti.global.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("aws.ses")
@Getter
@RequiredArgsConstructor
public class AwsSesProperties {

    private final String accessKey;

    private final String secretKey;

    private final String region;

}
