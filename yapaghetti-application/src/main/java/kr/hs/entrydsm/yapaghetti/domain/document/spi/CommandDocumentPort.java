package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;

import java.util.UUID;

public interface CommandDocumentPort {
    void saveDocument(Document document);

    void deleteDocument(Document document);

    UUID saveDocumentAndGetId(Document document);
}
