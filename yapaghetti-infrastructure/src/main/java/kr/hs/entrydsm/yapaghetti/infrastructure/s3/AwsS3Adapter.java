package kr.hs.entrydsm.yapaghetti.infrastructure.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import kr.hs.entrydsm.yapaghetti.domain.image.exception.ImageExtensionInvalidException;
import kr.hs.entrydsm.yapaghetti.domain.image.exception.ImageNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.image.spi.UploadS3Port;
import kr.hs.entrydsm.yapaghetti.domain.image.spi.type.ImageType;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import kr.hs.entrydsm.yapaghetti.global.property.AwsS3Properties;
import lombok.RequiredArgsConstructor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class AwsS3Adapter implements UploadS3Port {

    private final AmazonS3 amazonS3;

    private final AwsS3Properties awsS3Properties;

    @Override
    public String saveImage(File file, ImageType imageType) {
        String extension = getExtension(file);

        String folder = ImageType.PROFILE.equals(imageType) ? awsS3Properties.getProfileFolder() : awsS3Properties.getPreviewFolder();

        String filePath = folder + UUID.randomUUID() + "." + extension;
        uploadImage(file, filePath);

        return awsS3Properties.getUrl() + filePath;
    }

    public void deleteImage(String objectUrl) {
        String objectName = objectUrl.replace(awsS3Properties.getUrl(), "");
        String bucket = objectName.split("/")[0] + "/";

        amazonS3.deleteObject(bucket, objectName);
    }

    private String getExtension(File file) {
        if (file == null) {
            throw ImageNotFoundException.EXCEPTION;
        }

        String originalFilename = file.getName();
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

        if (!(extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") || extension.equals("heic"))) {
            throw ImageExtensionInvalidException.EXCEPTION;
        }
        return extension;
    }

    private void uploadImage(File file, String filePath) {
        byte[] bytes;
        ObjectMetadata objectMetadata;
        ByteArrayInputStream byteArrayInputStream;

        try {
            InputStream inputStream = new FileInputStream(file);
            bytes = IOUtils.toByteArray(inputStream);
            objectMetadata = objectMetadata(file, bytes);
            byteArrayInputStream = new ByteArrayInputStream(bytes);
        } catch (IOException e) {
            throw ImageNotFoundException.EXCEPTION;
        }

        amazonS3.putObject(
                new PutObjectRequest(
                        awsS3Properties.getBucket(),
                        filePath,
                        byteArrayInputStream,
                        objectMetadata
                ).withCannedAcl(CannedAccessControlList.AuthenticatedRead)
        );
    }

    private ObjectMetadata objectMetadata(File file, byte[] bytes) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(Mimetypes.getInstance().getMimetype(file));
        objectMetadata.setContentLength(bytes.length);
        return objectMetadata;
    }

}
