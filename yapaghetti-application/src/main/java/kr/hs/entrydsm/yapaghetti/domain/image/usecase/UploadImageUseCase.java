package kr.hs.entrydsm.yapaghetti.domain.image.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.image.api.UploadImagePort;
import kr.hs.entrydsm.yapaghetti.domain.image.api.dto.response.ImageUrlResponse;
import kr.hs.entrydsm.yapaghetti.domain.image.spi.type.ImageType;
import kr.hs.entrydsm.yapaghetti.domain.image.spi.UploadS3Port;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import lombok.RequiredArgsConstructor;

import java.io.File;

@RequiredArgsConstructor
@UseCase
public class UploadImageUseCase implements UploadImagePort {

    private final UserSecurityPort userSecurityPort;
    private final UploadS3Port uploadS3Port;

    @Override
    public ImageUrlResponse uploadImage(File file, ImageType imageType) {
        //TODO user 토큰 확인

        String path = uploadS3Port.saveImage(file, imageType);
        return new ImageUrlResponse(path);
    }

}
