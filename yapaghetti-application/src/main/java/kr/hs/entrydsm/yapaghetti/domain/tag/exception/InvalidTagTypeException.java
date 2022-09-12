package kr.hs.entrydsm.yapaghetti.domain.tag.exception;

import kr.hs.entrydsm.yapaghetti.domain.tag.error.TagErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class InvalidTagTypeException extends YapaghettiException {

	private InvalidTagTypeException() {
		super(TagErrorCode.INVALID_TAG_TYPE);
	}

	public static final YapaghettiException EXCEPTION = new InvalidTagTypeException();
}
