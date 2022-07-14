package kr.hs.entrydsm.yapaghetti.domain.auth.exception;

import kr.hs.entrydsm.yapaghetti.domain.auth.error.AuthCodeErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class AuthCodeNotVerifiedException extends YapaghettiException {

	private AuthCodeNotVerifiedException() {
		super(AuthCodeErrorCode.AUTH_CODE_NOT_VERIFIED);
	}

	public static final YapaghettiException EXCEPTION = new AuthCodeNotVerifiedException();
}

