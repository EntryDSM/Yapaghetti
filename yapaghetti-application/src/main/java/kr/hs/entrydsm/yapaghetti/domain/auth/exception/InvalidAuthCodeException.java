package kr.hs.entrydsm.yapaghetti.domain.auth.exception;

import kr.hs.entrydsm.yapaghetti.domain.auth.error.AuthCodeErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class InvalidAuthCodeException extends YapaghettiException {

	private InvalidAuthCodeException() {
		super(AuthCodeErrorCode.INVALID_AUTH_CODE);
	}

	public static final YapaghettiException EXCEPTION = new InvalidAuthCodeException();
}
