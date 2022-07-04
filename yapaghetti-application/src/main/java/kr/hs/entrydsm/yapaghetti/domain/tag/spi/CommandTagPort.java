package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;

import java.util.UUID;

public interface CommandTagPort {
    void saveTag(Tag tag);
    boolean existsById(UUID tagId);
    void deleteTagById(UUID tagId);
}
