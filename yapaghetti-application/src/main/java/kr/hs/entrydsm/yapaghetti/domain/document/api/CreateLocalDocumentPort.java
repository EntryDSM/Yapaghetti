package kr.hs.entrydsm.yapaghetti.domain.document.api;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainCreateLocalDocumentRequest;

public interface CreateLocalDocumentPort {
    void execute(DomainCreateLocalDocumentRequest request);
}
