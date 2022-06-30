package kr.hs.entrydsm.yapaghetti.global.property.config;

import kr.hs.entrydsm.yapaghetti.global.property.AwsS3Properties;
import kr.hs.entrydsm.yapaghetti.global.property.AwsSesProperties;
import kr.hs.entrydsm.yapaghetti.global.property.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = {AwsS3Properties.class, AwsSesProperties.class, JwtProperties.class})
@Configuration
public class ConfigurationPropertiesConfig {
}
