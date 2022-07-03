package kr.hs.entrydsm.yapaghetti.domain.image.api;

import kr.hs.entrydsm.yapaghetti.domain.image.api.dto.response.ImageUrlResponse;
import kr.hs.entrydsm.yapaghetti.domain.image.spi.type.ImageType;

import java.io.File;

public interface UploadImagePort {
    ImageUrlResponse uploadImage(File file, ImageType imageType);
}
