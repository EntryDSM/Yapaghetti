package kr.hs.entrydsm.yapaghetti.domain.tag.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class Tag {

    private UUID id;

    private String name;

    private TagType type;

}
