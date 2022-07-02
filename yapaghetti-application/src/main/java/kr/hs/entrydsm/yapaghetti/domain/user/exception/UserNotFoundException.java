package kr.hs.entrydsm.yapaghetti.domain.user.exception;

import kr.hs.entrydsm.yapaghetti.domain.user.error.UserErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class UserNotFoundException extends YapaghettiException {

    private UserNotFoundException() {
        super(UserErrorCode.USER_NOT_FOUND);
    }

    public static final YapaghettiException EXCEPTION = new UserNotFoundException();

}
