package kr.hs.entrydsm.yapaghetti.domain.document.api;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainCreateDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.CreateLocalDocumentResponse;

public interface CreateLocalDocumentPort {
    CreateLocalDocumentResponse execute(DomainCreateDocumentRequest request);
}
