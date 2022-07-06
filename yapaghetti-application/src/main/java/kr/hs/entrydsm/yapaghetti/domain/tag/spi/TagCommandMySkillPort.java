package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;

import java.util.List;
import java.util.UUID;

public interface TagCommandMySkillPort {
    void saveAllMySkill(List<MySkill> mySkills);
    void deleteAllMySKillByUserId(UUID userId);
}
