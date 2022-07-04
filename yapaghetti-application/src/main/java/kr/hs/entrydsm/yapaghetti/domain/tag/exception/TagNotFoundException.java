package kr.hs.entrydsm.yapaghetti.domain.tag.exception;

import kr.hs.entrydsm.yapaghetti.domain.tag.error.TagErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class TagNotFoundException extends YapaghettiException {

	private TagNotFoundException() {
		super(TagErrorCode.TAG_NOT_FOUND);
	}

	public static final YapaghettiException EXCEPTION = new TagNotFoundException();
}
