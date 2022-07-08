package kr.hs.entrydsm.yapaghetti.domain.document.api;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryStayDocumentResponse;

import java.util.UUID;

public interface QueryStayDocumentPort {
    QueryStayDocumentResponse execute(UUID documentId);
}
