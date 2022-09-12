package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import java.util.UUID;

public interface TagQueryMySkillPort {

    boolean existsMySkillByTagId(UUID tagId);
}
