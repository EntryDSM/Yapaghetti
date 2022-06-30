package kr.hs.entrydsm.yapaghetti.global.exception;

import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;
import kr.hs.entrydsm.yapaghetti.global.error.GlobalErrorCode;

public class ImageExtensionInvalidException extends YapaghettiException {

    public static final ImageExtensionInvalidException EXCEPTION = new ImageExtensionInvalidException();

    private ImageExtensionInvalidException() {
        super(GlobalErrorCode.IMAGE_EXTENSION_INVALID);
    }

}
