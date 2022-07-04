package kr.hs.entrydsm.yapaghetti.domain.document.exception;

import kr.hs.entrydsm.yapaghetti.domain.document.error.DocumentErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class DocumentNotFoundException extends YapaghettiException {

    private DocumentNotFoundException() {
        super(DocumentErrorCode.DOCUMENT_NOT_FOUND);
    }

    public static final DocumentNotFoundException EXCEPTION = new DocumentNotFoundException();

}
