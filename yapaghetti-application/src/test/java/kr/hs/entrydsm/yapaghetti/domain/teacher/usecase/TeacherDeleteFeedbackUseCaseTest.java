package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainDeleteFeedbackRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandFeedbackPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;


@ExtendWith(MockitoExtension.class)
public class TeacherDeleteFeedbackUseCaseTest {

    @Mock
    TeacherCommandFeedbackPort teacherCommandFeedbackPort;

    @InjectMocks
    DeleteFeedbackUseCase deleteFeedbackUseCase;


    @Test
    public void execute() {
        UUID documentId = UUID.randomUUID();
        Integer sequence = 0;

        deleteFeedbackUseCase.execute(
                new DomainDeleteFeedbackRequest(
                        documentId, sequence
                )
        );

    }

}
