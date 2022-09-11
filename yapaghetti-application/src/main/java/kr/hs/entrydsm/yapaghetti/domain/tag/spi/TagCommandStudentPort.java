package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import java.util.UUID;

public interface TagCommandStudentPort {
	boolean existsStudentByTagId(UUID tagId);
}
