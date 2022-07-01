package kr.hs.entrydsm.yapaghetti.global.exception;

import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;
import kr.hs.entrydsm.yapaghetti.global.error.GlobalErrorCode;

public class ImageNotFoundException extends YapaghettiException {

    public static final ImageNotFoundException EXCEPTION = new ImageNotFoundException();

    private ImageNotFoundException() {
        super(GlobalErrorCode.IMAGE_NOT_FOUND);
    }

}
