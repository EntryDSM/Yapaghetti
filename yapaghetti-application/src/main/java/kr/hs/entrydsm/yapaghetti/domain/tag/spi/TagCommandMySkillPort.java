package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import java.util.List;
import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;

public interface TagCommandMySkillPort {
	void saveAllMySkill(List<MySkill> mySkills);

	void deleteAllMySKillByUserId(UUID userId);
}
