package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainAddTagRequest;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.TagType;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.AlreadyExistsTagException;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.CommandTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class AddTagUseCaseTest {

    @Mock
    QueryTagPort queryTagPort;

    @Mock
    CommandTagPort saveTagPort;

    @InjectMocks
    AddTagUseCase addTagUseCase;

    @Mock
    DomainAddTagRequest request;

    @Test
    void 태그_저장() {
        String name = "프론트엔드";
        TagType type = TagType.MAJOR;

        given(request.getName()).willReturn(name);
        given(request.getIsMajor()).willReturn(true);

        given(TagType.MAJOR.equals(type) && request.getIsMajor()).willReturn(true);

        given(queryTagPort.existByName(name)).willReturn(false);

        addTagUseCase.execute(request);
    }

    @Test
    void 태그_저장_중복_이름() {
        String name = "프론트엔드";

        given(request.getName()).willReturn(name);
        given(queryTagPort.existByName(name)).willReturn(true);

        assertThatThrownBy(() -> addTagUseCase.execute(request))
                .isInstanceOf(AlreadyExistsTagException.class);
    }

}
