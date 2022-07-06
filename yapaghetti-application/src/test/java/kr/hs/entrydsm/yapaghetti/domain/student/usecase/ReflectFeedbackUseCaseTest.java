package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ReflectFeedbackUseCaseTest {

	@Mock
	StudentSecurityPort studentSecurityPort;

	@Mock
	StudentQueryDocumentPort studentQueryDocumentPort;

	@Mock
	StudentQueryFeedbackPort studentQueryFeedbackPort;

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
		given(studentQueryDocumentPort.queryDocumentByUserIdAndType(userId, documentType))
			.willReturn(
				Document.builder()
					.id(documentId)
					.build()
			);
		given(studentQueryFeedbackPort.queryFeedbackByDocumentIdAndSequence(documentId, sequence))
			.willReturn(
				Feedback.builder().build()
			);

		reflectFeedbackUseCase.execute(sequence);
	}
}
