package kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class DomainSetMajorTagRequest {

    private final UUID tagId;

}
