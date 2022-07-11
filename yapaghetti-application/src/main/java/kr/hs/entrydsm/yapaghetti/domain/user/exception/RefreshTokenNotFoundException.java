package kr.hs.entrydsm.yapaghetti.domain.user.exception;

import kr.hs.entrydsm.yapaghetti.domain.user.error.UserErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class RefreshTokenNotFoundException extends YapaghettiException {

    private RefreshTokenNotFoundException() {
        super(UserErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }

    public static final YapaghettiException EXCEPTION = new RefreshTokenNotFoundException();

}
