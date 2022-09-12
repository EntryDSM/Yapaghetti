package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.CommandTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagQueryMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagQueryStudentPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class DeleteTagUseCaseTest {

    @Mock
    CommandTagPort commandTagPort;

    @Mock
    QueryTagPort queryTagPort;

    @Mock
    TagQueryMySkillPort tagQueryMySkillPort;

    @Mock
    TagQueryStudentPort tagQueryStudentPort;

    @InjectMocks
    DeleteTagUseCase deleteTagUseCase;

    private static final UUID tagId = UUID.randomUUID();

    @Test
    void 태그_삭제_성공() {
        given(queryTagPort.existsTagById(tagId))
            .willReturn(true);

        deleteTagUseCase.execute(tagId);
    }

    @Test
    void 태그_존재_안함() {
        assertThrows(TagNotFoundException.class, () -> deleteTagUseCase.execute(tagId));
    }

}
