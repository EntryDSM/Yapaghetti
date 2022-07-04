package kr.hs.entrydsm.yapaghetti.domain.my_skill.spi;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;

import java.util.List;
import java.util.UUID;

public interface CommandMySkillPort {
    void saveAllMySkill(List<MySkill> mySkills);
    void deleteAllMySKillByUserId(UUID userId);
}
