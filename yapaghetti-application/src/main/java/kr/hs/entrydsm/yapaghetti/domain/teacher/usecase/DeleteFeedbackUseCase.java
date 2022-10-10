package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;


import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.DeleteFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainDeleteFeedbackRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandFeedbackPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class DeleteFeedbackUseCase implements DeleteFeedbackPort {

    private final TeacherCommandFeedbackPort teacherCommandFeedbackPort;

    @Override
    public void execute(DomainDeleteFeedbackRequest request) {

        teacherCommandFeedbackPort.deleteFeedbackByDocumentIdAndSequence(
                request.getDocumentId(), request.getSequence()
        );

    }

}
