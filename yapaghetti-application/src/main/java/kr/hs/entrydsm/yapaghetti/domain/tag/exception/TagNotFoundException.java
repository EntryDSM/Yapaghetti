package kr.hs.entrydsm.yapaghetti.domain.tag.exception;

import kr.hs.entrydsm.yapaghetti.domain.user.error.UserErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class TagNotFoundException extends YapaghettiException {

	private TagNotFoundException() {
		super(UserErrorCode.USER_NOT_FOUND);
	}

	public static final YapaghettiException EXCEPTION = new TagNotFoundException();
}
