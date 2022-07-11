package kr.hs.entrydsm.yapaghetti.domain.auth.exception;

import kr.hs.entrydsm.yapaghetti.domain.auth.error.AuthCodeErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class AuthCodeOverLimitException extends YapaghettiException {

	private AuthCodeOverLimitException() {
		super(AuthCodeErrorCode.AUTH_CODE_OVER_LIMIT);
	}

	public static final YapaghettiException EXCEPTION = new AuthCodeOverLimitException();
}
