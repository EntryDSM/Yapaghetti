package kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainAddTagRequest {

    private final String name;

    private final Boolean isMajor;

}
