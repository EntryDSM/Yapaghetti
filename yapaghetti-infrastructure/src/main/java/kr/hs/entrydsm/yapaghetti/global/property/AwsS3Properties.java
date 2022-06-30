package kr.hs.entrydsm.yapaghetti.global.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("aws.s3")
@Getter
@RequiredArgsConstructor
public class AwsS3Properties {

    private final String url;

    private final String bucket;

    private final String profileFolder;

    private final String previewFolder;

}
