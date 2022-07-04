package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;

import java.util.UUID;

public interface QueryDocumentPort {
    Document queryDocumentById(UUID id);
    Document queryPublicDocumentByUserId(UUID userId);
    Document queryStayDocumentByUserId(UUID userId);
}
