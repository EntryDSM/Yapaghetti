package kr.hs.entrydsm.yapaghetti.domain.company.api;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response.QueryDocumentForCompanyResponse;

public interface QueryPublicDocumentForCompanyPort {
	QueryDocumentForCompanyResponse execute(UUID studentId);
}
