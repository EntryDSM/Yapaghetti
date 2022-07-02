package kr.hs.entrydsm.yapaghetti.global.security.exception;

import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;
import kr.hs.entrydsm.yapaghetti.global.error.GlobalErrorCode;

public class InvalidTokenException extends YapaghettiException {

    private InvalidTokenException() {
        super(GlobalErrorCode.INVALID_TOKEN);
    }

    public static final YapaghettiException EXCEPTION = new InvalidTokenException();

}
