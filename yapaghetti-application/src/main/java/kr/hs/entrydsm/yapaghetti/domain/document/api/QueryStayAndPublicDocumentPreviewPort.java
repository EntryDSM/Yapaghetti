package kr.hs.entrydsm.yapaghetti.domain.document.api;

import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryStayAndPublicDocumentPreviewResponse;

import java.util.UUID;

public interface QueryStayAndPublicDocumentPreviewPort {
    QueryStayAndPublicDocumentPreviewResponse execute(UUID studentId);
}
