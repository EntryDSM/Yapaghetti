package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.ReflectFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class ReflectFeedbackUseCase implements ReflectFeedbackPort {

	private final StudentSecurityPort studentSecurityPort;
	private final StudentQueryDocumentPort studentQueryDocumentPort;
	private final StudentQueryFeedbackPort studentQueryFeedbackPort;
	private final CommandFeedbackPort commandFeedbackPort;

	@Override
	public void execute(Integer sequence) {
		UUID userId = studentSecurityPort.getCurrentUserId();

		Document document = studentQueryDocumentPort
			.queryDocumentByUserIdAndType(userId, DocumentType.STAY);

		Feedback feedback = studentQueryFeedbackPort
			.queryFeedbackByDocumentIdAndSequence(document.getId(), sequence)
			.reflectFeedback();

		commandFeedbackPort.saveFeedback(feedback);
	}
}
