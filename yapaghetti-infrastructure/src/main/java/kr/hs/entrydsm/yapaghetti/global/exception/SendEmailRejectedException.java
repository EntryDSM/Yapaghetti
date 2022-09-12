package kr.hs.entrydsm.yapaghetti.global.exception;

import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;
import kr.hs.entrydsm.yapaghetti.global.error.GlobalErrorCode;

public class SendEmailRejectedException extends YapaghettiException {

	private SendEmailRejectedException() {
		super(GlobalErrorCode.SEND_EMAIL_REJECTED);
	}

	public static final YapaghettiException EXCEPTION = new SendEmailRejectedException();

}