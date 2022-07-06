package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;

import java.util.List;
import java.util.UUID;

public interface StudentQueryMySkillPort {
    List<MySkill> queryMySkillByUserId(UUID userId);
}
