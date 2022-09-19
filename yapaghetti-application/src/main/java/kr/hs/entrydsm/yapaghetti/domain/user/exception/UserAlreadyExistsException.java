package kr.hs.entrydsm.yapaghetti.domain.user.exception;

import kr.hs.entrydsm.yapaghetti.domain.user.error.UserErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class UserAlreadyExistsException extends YapaghettiException {

	private UserAlreadyExistsException() {
		super(UserErrorCode.USER_AREADY_EXISTS);
	}

	public static final YapaghettiException EXCEPTION = new UserAlreadyExistsException();
}
