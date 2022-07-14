package kr.hs.entrydsm.yapaghetti.global.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties("aws.ses")
public class AwsSesProperties {

    private final String accessKey;

    private final String secretKey;

    private final String sesSource;

    private final String region;

}
