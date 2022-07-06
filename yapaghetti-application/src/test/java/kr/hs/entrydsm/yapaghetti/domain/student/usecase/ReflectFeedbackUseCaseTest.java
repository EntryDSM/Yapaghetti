package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ReflectFeedbackUseCaseTest {

	@Mock
	StudentSecurityPort studentSecurityPort;

	@Mock
	QueryDocumentPort queryDocumentPort;

	@Mock
	QueryFeedbackPort queryFeedBackPort;

	@Mock
	CommandFeedbackPort commandFeedbackPort;

	@InjectMocks
	ReflectFeedbackUseCase reflectFeedbackUseCase;

	@Test
	void execute() {
		UUID userId = UUID.randomUUID();
		UUID documentId = UUID.randomUUID();

		DocumentType documentType = DocumentType.STAY;
		Integer sequence = 1;

		given(studentSecurityPort.getCurrentUserId())
			.willReturn(userId);
		given(queryDocumentPort.queryDocumentByUserIdAndType(userId, documentType))
			.willReturn(
				Document.builder()
					.id(documentId)
					.build()
			);
		given(queryFeedBackPort.queryFeedbackByDocumentIdAndSequence(documentId, sequence))
			.willReturn(
				Feedback.builder().build()
			);

		reflectFeedbackUseCase.execute(sequence);
	}
}
