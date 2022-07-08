package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.CommandStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.QueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainSetMajorTagRequest;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagQueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class SetMajorTagUseCaseTest {

    @Mock
    TagSecurityPort tagSecurityPort;

    @Mock
    TagQueryStudentPort tagQueryStudentPort;

    @Mock
    QueryTagPort queryTagPort;

    @Mock
    CommandStudentPort commandStudentPort;

    @InjectMocks
    SetMajorTagUseCase setMajorTagUseCase;

    @Test
    void 대표_분야_설정() {
        UUID userId = UUID.randomUUID();
        UUID tagId = UUID.randomUUID();

        given(tagSecurityPort.getCurrentUserId()).willReturn(userId);
        given(tagQueryStudentPort.queryUserById(userId)).willReturn(
                Student.builder()
                        .userId(userId)
                        .grade(3)
                        .classNum(1)
                        .number(13)
                        .tagId(UUID.randomUUID())
                        .build()
        );

        queryTagPort.existsById(tagId);
        setMajorTagUseCase.execute(new DomainSetMajorTagRequest(tagId));
    }

}
