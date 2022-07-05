package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.feedback.spi.CommandFeedBackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedBackRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CreateFeedBackTest {

    @Mock
    QueryDocumentPort queryDocumentPort;

    @Mock
    CommandFeedBackPort commandFeedBackPort;

    @InjectMocks
    CreateFeedBackUseCase createFeedBackUseCase;

    @Mock
    DomainCreateFeedBackRequest request;

    @Test
    void createFeedBack() {
        UUID studentId = UUID.randomUUID();
        Integer sequence = 1;
        String comment = "이 부분 알잘딱 부탁 드립니다^^";

        given(request.getStudentId())
                .willReturn(studentId);
        given(request.getComment())
                .willReturn(comment);
        given(request.getSequence())
                .willReturn(sequence);
        given(queryDocumentPort.queryDocumentByUserIdAndType(studentId, DocumentType.STAY))
                .willReturn(Document.builder().build());

        createFeedBackUseCase.createFeedBack(request);
    }

}
