package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;

import java.util.UUID;

public interface TeacherQueryTagPort {
    Tag queryTagById(UUID tagId);

    Tag queryMajorTagByID(UUID tagId);
}
