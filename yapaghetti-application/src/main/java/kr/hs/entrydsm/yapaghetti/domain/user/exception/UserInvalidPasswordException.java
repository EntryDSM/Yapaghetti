package kr.hs.entrydsm.yapaghetti.domain.user.exception;

import kr.hs.entrydsm.yapaghetti.domain.user.error.UserErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class UserInvalidPasswordException extends YapaghettiException {

    private UserInvalidPasswordException() {
        super(UserErrorCode.USER_INVALID_PASSWORD);
    }

    public static final YapaghettiException EXCEPTION = new UserInvalidPasswordException();

}
