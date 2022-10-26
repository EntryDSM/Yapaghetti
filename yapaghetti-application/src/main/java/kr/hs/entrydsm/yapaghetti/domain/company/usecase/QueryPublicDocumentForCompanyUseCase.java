package kr.hs.entrydsm.yapaghetti.domain.company.usecase;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.domain.company.api.QueryPublicDocumentForCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response.QueryDocumentForCompanyResponse;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyQueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class QueryPublicDocumentForCompanyUseCase implements QueryPublicDocumentForCompanyPort {

	private final CompanyQueryDocumentPort  companyQueryDocumentPort;

	@Override
	public QueryDocumentForCompanyResponse execute(UUID studentId) {
		Document publicDocument = companyQueryDocumentPort.queryDocumentByUserIdAndType(studentId, DocumentType.PUBLIC);

		return new QueryDocumentForCompanyResponse(publicDocument.getContent());
	}
}
