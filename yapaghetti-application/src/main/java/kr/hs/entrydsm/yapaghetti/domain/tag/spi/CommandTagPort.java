package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;

import java.util.UUID;

public interface CommandTagPort {
    void saveTag(Tag tag);
    void deleteTagById(UUID tagId);
}
