package kr.hs.entrydsm.yapaghetti.domain.image.spi;

import kr.hs.entrydsm.yapaghetti.domain.image.spi.type.ImageType;

import java.io.File;

public interface UploadS3Port {

    String saveImage(File file, ImageType imageType);

}
