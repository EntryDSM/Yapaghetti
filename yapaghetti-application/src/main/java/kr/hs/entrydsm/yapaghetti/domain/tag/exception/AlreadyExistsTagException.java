package kr.hs.entrydsm.yapaghetti.domain.tag.exception;

import kr.hs.entrydsm.yapaghetti.domain.tag.error.TagErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class AlreadyExistsTagException extends YapaghettiException {

    public static final AlreadyExistsTagException EXCEPTION = new AlreadyExistsTagException();

    private AlreadyExistsTagException() {
        super(TagErrorCode.ALREADY_EXISTS_TAG);
    }

}
