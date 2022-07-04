package kr.hs.entrydsm.yapaghetti.domain.my_skill.spi;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;

import java.util.List;

public interface CommandMySkillPort {
    void saveAllMySkill(List<MySkill> mySkills);
}
