package kr.hs.entrydsm.yapaghetti.domain.my_skill.spi;

import java.util.List;
import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;

public interface QueryMySkillPort {
	List<MySkill> queryMySkillByUserId(UUID userId);
}
