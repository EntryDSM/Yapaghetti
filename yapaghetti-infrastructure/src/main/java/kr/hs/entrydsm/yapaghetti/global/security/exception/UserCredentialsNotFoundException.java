package kr.hs.entrydsm.yapaghetti.global.security.exception;

import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;
import kr.hs.entrydsm.yapaghetti.global.error.GlobalErrorCode;

public class UserCredentialsNotFoundException extends YapaghettiException {

    private UserCredentialsNotFoundException() {
        super(GlobalErrorCode.USER_CREDENTIALS_NOT_FOUND);
    }

    public static final YapaghettiException EXCEPTION = new UserCredentialsNotFoundException();

}
