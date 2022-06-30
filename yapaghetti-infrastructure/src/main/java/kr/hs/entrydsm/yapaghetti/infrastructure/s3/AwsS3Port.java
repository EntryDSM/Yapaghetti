package kr.hs.entrydsm.yapaghetti.infrastructure.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import kr.hs.entrydsm.yapaghetti.global.property.AwsS3Properties;
import kr.hs.entrydsm.yapaghetti.infrastructure.s3.type.ImageType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class AwsS3Port {

    private final AmazonS3 amazonS3;

    private final AwsS3Properties awsS3Properties;

    private static final String EXTENSION = ".jpeg";

    public String saveImage(MultipartFile file, ImageType imageType) {
        String folder = imageType.equals(ImageType.PROFILE) ? awsS3Properties.getProfileFolder() : awsS3Properties.getPreviewFolder();
        String filePath = folder + UUID.randomUUID() + EXTENSION;

        uploadImage(file, filePath);

        return awsS3Properties.getUrl() + filePath;
    }

    public void deleteImage(String objectUrl) {
        String objectName = objectUrl.replace(awsS3Properties.getUrl(), "");
        String bucket = objectName.split("/")[0] + "/";

        amazonS3.deleteObject(bucket, objectName);
    }

    private void uploadImage(MultipartFile file, String filePath) {
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException();
            //exception 수정
        }

        amazonS3.putObject(
                new PutObjectRequest(
                        awsS3Properties.getBucket(),
                        filePath,
                        inputStream,
                        null
                )
        );
    }

}
