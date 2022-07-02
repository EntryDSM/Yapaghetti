package kr.hs.entrydsm.yapaghetti.domain.user.exception;

import kr.hs.entrydsm.yapaghetti.domain.user.error.UserErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class UserInvalidRoleException extends YapaghettiException {

    private UserInvalidRoleException() {
        super(UserErrorCode.USER_INVALID_ROLE);
    }

    public static final YapaghettiException EXCEPTION = new UserInvalidRoleException();

}
