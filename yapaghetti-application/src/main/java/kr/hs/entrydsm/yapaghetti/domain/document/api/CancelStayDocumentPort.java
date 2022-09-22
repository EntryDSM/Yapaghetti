package kr.hs.entrydsm.yapaghetti.domain.document.api;

import java.util.UUID;

public interface CancelStayDocumentPort {
    void execute(UUID studentId);
}
