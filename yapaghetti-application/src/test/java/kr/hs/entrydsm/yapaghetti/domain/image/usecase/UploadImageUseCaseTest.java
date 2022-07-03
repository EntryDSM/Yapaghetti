package kr.hs.entrydsm.yapaghetti.domain.image.usecase;

import kr.hs.entrydsm.yapaghetti.domain.image.spi.UploadS3Port;
import kr.hs.entrydsm.yapaghetti.domain.image.spi.type.ImageType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UploadImageUseCaseTest {

    @Mock
    private UploadS3Port uploadS3Port;

    @InjectMocks
    private UploadImageUseCase uploadImageUseCase;
    
    @Test
    void 사진_등록() {
        File file = new File("previewImagePath.jpg");

        given(uploadS3Port.saveImage(file, ImageType.PREVIEW)).willReturn(
                "/preview/" + UUID.randomUUID() + ".jpg"
        );

        uploadImageUseCase.uploadImage(file, ImageType.PREVIEW);
    }

}
