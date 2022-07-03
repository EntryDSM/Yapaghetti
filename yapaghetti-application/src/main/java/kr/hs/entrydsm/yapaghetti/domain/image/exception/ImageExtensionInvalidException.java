package kr.hs.entrydsm.yapaghetti.domain.image.exception;

import kr.hs.entrydsm.yapaghetti.domain.image.error.ImageErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class ImageExtensionInvalidException extends YapaghettiException {

    public static final ImageExtensionInvalidException EXCEPTION = new ImageExtensionInvalidException();

    private ImageExtensionInvalidException() {
        super(ImageErrorCode.IMAGE_EXTENSION_INVALID);
    }

}
