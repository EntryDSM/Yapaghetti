package kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class DomainTagDto {

    private final UUID tagId;

    private final String name;

}
