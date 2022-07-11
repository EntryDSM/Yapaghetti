package kr.hs.entrydsm.yapaghetti.domain.auth.exception;

import kr.hs.entrydsm.yapaghetti.domain.auth.error.AuthCodeErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class AuthCodeAlreadyVerifiedException extends YapaghettiException {

	private AuthCodeAlreadyVerifiedException() {
		super(AuthCodeErrorCode.AUTH_CODE_ALREADY_VERIFIED);
	}

	public static final YapaghettiException EXCEPTION = new AuthCodeAlreadyVerifiedException();
}
