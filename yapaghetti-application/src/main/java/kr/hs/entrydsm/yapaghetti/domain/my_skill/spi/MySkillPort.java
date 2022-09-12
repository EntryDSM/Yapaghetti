package kr.hs.entrydsm.yapaghetti.domain.my_skill.spi;

import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagCommandMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagQueryMySkillPort;

public interface MySkillPort extends StudentQueryMySkillPort, TagQueryMySkillPort,
	TagCommandMySkillPort {
}
