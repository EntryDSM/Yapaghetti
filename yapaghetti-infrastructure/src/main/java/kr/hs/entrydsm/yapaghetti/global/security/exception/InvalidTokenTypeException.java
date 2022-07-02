package kr.hs.entrydsm.yapaghetti.global.security.exception;

import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;
import kr.hs.entrydsm.yapaghetti.global.error.GlobalErrorCode;

public class InvalidTokenTypeException extends YapaghettiException {

    private InvalidTokenTypeException() {
        super(GlobalErrorCode.INVALID_TOKEN_TYPE);
    }

    public static final YapaghettiException EXCEPTION = new InvalidTokenTypeException();

}
