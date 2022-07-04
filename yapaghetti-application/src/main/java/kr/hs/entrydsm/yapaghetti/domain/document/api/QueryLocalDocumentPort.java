package kr.hs.entrydsm.yapaghetti.domain.document.api;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryDocumentResponse;

import java.util.UUID;

public interface QueryLocalDocumentPort {
    QueryDocumentResponse execute(UUID documentId);
}
