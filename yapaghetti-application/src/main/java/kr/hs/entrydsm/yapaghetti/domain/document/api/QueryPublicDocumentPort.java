package kr.hs.entrydsm.yapaghetti.domain.document.api;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryPublicDocumentResponse;

import java.util.UUID;

public interface QueryPublicDocumentPort {
    QueryPublicDocumentResponse execute(UUID documentId);
}
