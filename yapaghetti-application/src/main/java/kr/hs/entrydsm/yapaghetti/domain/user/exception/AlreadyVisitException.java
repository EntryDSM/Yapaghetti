package kr.hs.entrydsm.yapaghetti.domain.user.exception;

import kr.hs.entrydsm.yapaghetti.domain.user.error.UserErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class AlreadyVisitException extends YapaghettiException {

    private AlreadyVisitException() {
        super(UserErrorCode.ALREADY_VISIT);
    }

    public static final YapaghettiException EXCEPTION = new AlreadyVisitException();
}
