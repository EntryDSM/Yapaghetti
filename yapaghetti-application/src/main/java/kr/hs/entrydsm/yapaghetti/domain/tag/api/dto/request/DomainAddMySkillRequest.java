package kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class DomainAddMySkillRequest {

    private final List<UUID> tagList;

}
