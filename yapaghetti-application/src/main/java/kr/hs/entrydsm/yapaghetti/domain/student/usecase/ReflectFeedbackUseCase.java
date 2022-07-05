package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.domain.Feedback;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.QueryFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.ReflectFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class ReflectFeedbackUseCase implements ReflectFeedbackPort {

	private final StudentSecurityPort studentSecurityPort;
	private final QueryDocumentPort queryDocumentPort;
	private final QueryFeedbackPort queryFeedBackPort;
	private final CommandFeedbackPort commandFeedbackPort;

	@Override
	public void execute(Integer sequence) {
		UUID userId = studentSecurityPort.getCurrentUserId();

		Document document = queryDocumentPort
			.queryDocumentByUserIdAndType(userId, DocumentType.PROTECTED);

		Feedback feedback = queryFeedBackPort
			.queryFeedbackByDocumentIdAndSequence(document.getId(), sequence)
			.reflectFeedback();

		commandFeedbackPort.updateFeedback(feedback);
	}
}
