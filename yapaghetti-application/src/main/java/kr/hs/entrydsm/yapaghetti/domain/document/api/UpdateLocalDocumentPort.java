package kr.hs.entrydsm.yapaghetti.domain.document.api;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateLocalDocumentRequest;

public interface UpdateLocalDocumentPort {
    void execute(DomainUpdateLocalDocumentRequest request);
}
