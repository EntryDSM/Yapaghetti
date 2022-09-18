package kr.hs.entrydsm.yapaghetti.domain.document.api;

import java.util.UUID;

public interface ApproveStayDocumentPort {
    void execute(UUID studentId);
}
