package kr.hs.entrydsm.yapaghetti.domain.my_skill.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class MySkill {

    private final UUID tagId;

    private final UUID userId;

}
