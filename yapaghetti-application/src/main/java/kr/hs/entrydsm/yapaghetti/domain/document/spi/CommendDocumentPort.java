package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;

public interface CommendDocumentPort {
    void saveDocument(Document document);
}
