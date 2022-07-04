package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.GetTagListPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.response.DomainTagDto;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.response.DomainTagListResponse;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
public class GetTagListUseCase implements GetTagListPort {

    private final QueryTagPort queryTagPort;

    @Override
    public DomainTagListResponse execute(String name, boolean isMajor) {
        String queryTagName = "%" + name + "%";

        List<DomainTagDto> tags = queryTagPort.findAllByNameAndIsMajor(name, isMajor).stream()
                .map(t -> DomainTagDto.builder()
                            .tagId(t.getId())
                            .name(t.getName())
                            .build())
                .collect(Collectors.toList());

        return new DomainTagListResponse(tags);
    }

}
