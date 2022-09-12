package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;

import java.util.List;
import java.util.UUID;

public interface QueryTagPort {
    Tag queryTagById(UUID tagId);

    List<Tag> queryAllTagByNameContainingAndIsMajor(String name, boolean isMajor);

    boolean existsTagByName(String name);

    boolean existsTagById(UUID tagId);
}
