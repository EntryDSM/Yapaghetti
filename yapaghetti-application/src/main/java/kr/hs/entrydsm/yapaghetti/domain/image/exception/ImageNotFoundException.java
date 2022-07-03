package kr.hs.entrydsm.yapaghetti.domain.image.exception;

import kr.hs.entrydsm.yapaghetti.domain.image.error.ImageErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class ImageNotFoundException extends YapaghettiException {

    public static final ImageNotFoundException EXCEPTION = new ImageNotFoundException();

    private ImageNotFoundException() {
        super(ImageErrorCode.IMAGE_NOT_FOUND);
    }

}
