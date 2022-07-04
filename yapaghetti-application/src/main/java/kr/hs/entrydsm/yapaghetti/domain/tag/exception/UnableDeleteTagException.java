package kr.hs.entrydsm.yapaghetti.domain.tag.exception;

import kr.hs.entrydsm.yapaghetti.domain.tag.error.TagErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class UnableDeleteTagException extends YapaghettiException {

    public static final UnableDeleteTagException EXCEPTION = new UnableDeleteTagException();

    private UnableDeleteTagException() {
        super(TagErrorCode.UNABLE_DELETE_TAG);
    }

}
