package kr.hs.entrydsm.yapaghetti.domain.document.api;

import java.util.UUID;

public interface RejectStayDocumentPort {
    void execute(UUID documentId);
}
