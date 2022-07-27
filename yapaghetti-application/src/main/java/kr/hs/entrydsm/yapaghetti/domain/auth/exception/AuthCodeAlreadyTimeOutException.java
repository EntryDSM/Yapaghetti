package kr.hs.entrydsm.yapaghetti.domain.auth.exception;

import kr.hs.entrydsm.yapaghetti.domain.auth.error.AuthCodeErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class AuthCodeAlreadyTimeOutException extends YapaghettiException {

    private AuthCodeAlreadyTimeOutException() {
        super(AuthCodeErrorCode.AUTH_CODE_ALREADY_TIMEOUT);
    }

    public static final YapaghettiException EXCEPTION = new AuthCodeAlreadyTimeOutException();
}
