package kr.hs.entrydsm.yapaghetti.domain.document.api;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateStayDocumentRequest;

public interface UpdateStayDocumentPort {
    void execute(DomainUpdateStayDocumentRequest request);
}
