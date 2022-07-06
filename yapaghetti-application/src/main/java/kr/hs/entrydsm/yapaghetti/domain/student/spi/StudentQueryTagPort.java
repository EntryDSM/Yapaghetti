package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;

import java.util.UUID;

public interface StudentQueryTagPort {
    Tag queryTagById(UUID tagId);
}
