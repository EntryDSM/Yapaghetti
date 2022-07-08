package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;

import java.util.List;
import java.util.UUID;

public interface TeacherQueryMySkillPort {
    List<MySkill> queryMySkillByUserId(UUID userId);
}
