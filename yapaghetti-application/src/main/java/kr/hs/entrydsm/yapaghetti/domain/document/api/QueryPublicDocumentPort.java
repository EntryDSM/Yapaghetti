package kr.hs.entrydsm.yapaghetti.domain.document.api;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryDocumentResponse;

public interface QueryPublicDocumentPort {
    QueryDocumentResponse execute(UUID studentId);
}
