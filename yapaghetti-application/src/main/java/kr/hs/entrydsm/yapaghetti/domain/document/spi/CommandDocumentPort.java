package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;

public interface CommandDocumentPort {
    void saveDocument(Document document);
    void updateDocument(Document document);
    void deleteDocument(Document document);
    void cancelStayDocument(Document document);
}
