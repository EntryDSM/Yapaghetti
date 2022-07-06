package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;

import java.util.UUID;

public interface StudentQueryDocumentPort {
    Document queryDocumentByUserIdAndType(UUID userId, DocumentType type);
}
