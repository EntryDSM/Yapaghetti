package kr.hs.entrydsm.yapaghetti.infrastructure.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import kr.hs.entrydsm.yapaghetti.global.exception.ImageExtensionInvalidException;
import kr.hs.entrydsm.yapaghetti.global.exception.ImageNotFoundException;
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

    public String saveImage(MultipartFile file, ImageType imageType) {
        String extension = getExtension(file);

        String folder = imageType.equals(ImageType.PROFILE) ? awsS3Properties.getProfileFolder() : awsS3Properties.getPreviewFolder();

        String filePath = folder + UUID.randomUUID() + extension;

        uploadImage(file, filePath);

        return awsS3Properties.getUrl() + filePath;
    }

    public void deleteImage(String objectUrl) {
        String objectName = objectUrl.replace(awsS3Properties.getUrl(), "");
        String bucket = objectName.split("/")[0] + "/";

        amazonS3.deleteObject(bucket, objectName);
    }

    private String getExtension(MultipartFile file) {
        if (file == null || file.isEmpty() || file.getOriginalFilename() == null) {
            throw ImageNotFoundException.EXCEPTION;
        }

        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

        if (!(extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") || extension.equals("heic"))) {
            throw ImageExtensionInvalidException.EXCEPTION;
        }
        return extension;
    }

    private void uploadImage(MultipartFile file, String filePath) {
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw ImageNotFoundException.EXCEPTION;
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
