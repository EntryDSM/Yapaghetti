package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.CommandTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class DeleteTagUseCaseTest {

    @Mock
    CommandTagPort commandTagPort;

    @Mock
    QueryTagPort queryTagPort;

    @InjectMocks
    DeleteTagUseCase deleteTagUseCase;

    private static final UUID tagId = UUID.randomUUID();

    @Test
    void 태그_삭제() {
        given(queryTagPort.existsById(tagId)).willReturn(true);

        deleteTagUseCase.execute(tagId);
    }

    @Test
    void 태그_삭제_실패() {
        given(queryTagPort.existsById(tagId)).willReturn(false);

        assertThatThrownBy(() -> deleteTagUseCase.execute(tagId))
                .isInstanceOf(TagNotFoundException.class);
    }

}
