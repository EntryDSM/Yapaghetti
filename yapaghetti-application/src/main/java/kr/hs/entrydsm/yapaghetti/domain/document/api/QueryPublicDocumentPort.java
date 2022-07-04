package kr.hs.entrydsm.yapaghetti.domain.document.api;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryDocumentResponse;

import java.util.UUID;

public interface QueryPublicDocumentPort {
    QueryDocumentResponse execute(UUID documentId);
}
