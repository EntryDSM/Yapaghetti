package kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence;

import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class MySkillPersistenceAdapter {

    private final MySkillRepository mySkillRepository;

    public boolean existsByTagId(UUID tagId) {
        return mySkillRepository.existsByTagId(tagId);
    }

}
