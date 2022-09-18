package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;

import java.util.List;
import java.util.UUID;

public interface QueryDocumentPort {
    Document queryDocumentByIdAndType(UUID documentId, DocumentType type);

    Document queryDocumentByIdAndUserIdAndType(UUID documentId, UUID userId, DocumentType type);

    Document queryDocumentByUserIdAndType(UUID userId, DocumentType type);

    List<Document> queryDocumentAllByUserIdAndType(UUID userId, DocumentType type);

    List<Document> queryDocumentAllByUserIdAndTypeNotIn(UUID userId, List<DocumentType> type);

    Boolean checkDocumentByUserIdAndType(UUID userId, DocumentType type);
}
