package kr.hs.entrydsm.yapaghetti.domain.auth.exception;

import kr.hs.entrydsm.yapaghetti.domain.auth.error.AuthCodeErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class AuthCodeLimitNotFoundException extends YapaghettiException {

	private AuthCodeLimitNotFoundException() {
		super(AuthCodeErrorCode.AUTH_CODE_LIMIT_NOT_FOUND);
	}

	public static final YapaghettiException EXCEPTION = new AuthCodeLimitNotFoundException();

}
