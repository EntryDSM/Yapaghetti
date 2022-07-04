package kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class TagElement {

    private final UUID tagId;

    private final String name;

}
