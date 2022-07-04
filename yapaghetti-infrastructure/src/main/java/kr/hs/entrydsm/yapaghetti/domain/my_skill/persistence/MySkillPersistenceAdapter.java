package kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class MySkillPersistenceAdapter {

    private final MySkillRepository mySkillRepository;

    public boolean existsByTagId(UUID tagId) {
        return mySkillRepository.existsByTagId(tagId);
    }

}
