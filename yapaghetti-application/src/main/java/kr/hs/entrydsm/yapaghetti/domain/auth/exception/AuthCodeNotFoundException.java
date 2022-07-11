package kr.hs.entrydsm.yapaghetti.domain.auth.exception;

import kr.hs.entrydsm.yapaghetti.domain.auth.error.AuthCodeErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class AuthCodeNotFoundException extends YapaghettiException {

	private AuthCodeNotFoundException() {
		super(AuthCodeErrorCode.AUTH_CODE_NOT_FOUND);
	}

	public static final YapaghettiException EXCEPTION = new AuthCodeNotFoundException();

}