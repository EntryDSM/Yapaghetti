package kr.hs.entrydsm.yapaghetti.domain.company.spi;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;

public interface CompanyQueryDocumentPort {

	Document queryDocumentByUserIdAndType(UUID userId, DocumentType type);
}
