package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.GetTagListPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.response.TagDto;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.response.TagListResponse;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
public class GetTagListUseCase implements GetTagListPort {

    private final QueryTagPort queryTagPort;

    @Override
    public TagListResponse execute(String name, boolean isMajor) {
        String queryTagName = "%" + name + "%";

        List<TagDto> tags = queryTagPort.findAllByNameLikeAndIsMajor(queryTagName, isMajor).stream()
                .map(t -> TagDto.builder()
                            .tagId(t.getId())
                            .name(t.getName())
                            .build())
                .collect(Collectors.toList());

        return new TagListResponse(tags);
    }

}
