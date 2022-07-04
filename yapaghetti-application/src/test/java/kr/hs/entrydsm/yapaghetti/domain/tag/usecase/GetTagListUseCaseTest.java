package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.TagType;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class GetTagListUseCaseTest {

    @Mock
    QueryTagPort queryTagPort;

    @InjectMocks
    GetTagListUseCase getTagListUseCase;

    @Test
    void 태그목록() {
        String name = "J";
        boolean isMajor = false;

        List<Tag> tags = new ArrayList<>();
        tags.add(addTag("Java"));
        tags.add(addTag("JavaScript"));

        given(queryTagPort.findAllByNameAndIsMajor(name, isMajor))
                .willReturn(tags);

        getTagListUseCase.execute(name, isMajor);
    }

    private Tag addTag(String name) {
        return Tag.builder()
                .id(UUID.randomUUID())
                .type(TagType.SKILL)
                .name(name)
                .build();
    }

}
