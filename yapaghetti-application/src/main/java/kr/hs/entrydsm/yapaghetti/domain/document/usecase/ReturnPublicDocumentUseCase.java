package kr.hs.entrydsm.yapaghetti.domain.document.usecase;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.api.ReturnPublicDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class ReturnPublicDocumentUseCase implements ReturnPublicDocumentPort {

	private final DocumentQueryUserPort documentQueryUserPort;
	private final QueryDocumentPort queryDocumentPort;
	private final CommandDocumentPort commandDocumentPort;

	public void execute(UUID studentId) {

		User user = documentQueryUserPort.queryUserById(studentId);
		Document document = queryDocumentPort.queryDocumentByUserIdAndType(user.getId(),
			DocumentType.PUBLIC);

		commandDocumentPort.saveDocument(
			document.changeDocumentType(DocumentType.LOCAL)
		);
	}
}
