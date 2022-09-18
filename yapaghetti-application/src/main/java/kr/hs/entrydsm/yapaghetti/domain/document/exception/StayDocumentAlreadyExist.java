package kr.hs.entrydsm.yapaghetti.domain.document.exception;

import kr.hs.entrydsm.yapaghetti.domain.document.error.DocumentErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class StayDocumentAlreadyExist extends YapaghettiException {

    private StayDocumentAlreadyExist() {super(DocumentErrorCode.STAY_DOCUMENT_ALREADY_EXIST);}

    public static final StayDocumentAlreadyExist EXCEPTION = new StayDocumentAlreadyExist();

}
