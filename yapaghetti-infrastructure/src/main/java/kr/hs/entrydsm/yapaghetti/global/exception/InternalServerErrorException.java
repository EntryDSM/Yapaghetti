package kr.hs.entrydsm.yapaghetti.global.exception;

import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;
import kr.hs.entrydsm.yapaghetti.global.error.GlobalErrorCode;

public class InternalServerErrorException extends YapaghettiException {

    private InternalServerErrorException() {
        super(GlobalErrorCode.INTERNAL_SERVER_ERROR);
    }

    public static final YapaghettiException EXCEPTION = new InternalServerErrorException();

}
