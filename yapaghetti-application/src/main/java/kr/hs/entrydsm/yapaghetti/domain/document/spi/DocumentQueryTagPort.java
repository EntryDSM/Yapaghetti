package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;

import java.util.UUID;

public interface DocumentQueryTagPort {
    Tag queryMajorTagByStudentId(UUID studentId);
}
