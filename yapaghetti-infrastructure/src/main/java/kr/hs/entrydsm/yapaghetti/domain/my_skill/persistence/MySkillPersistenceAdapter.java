package kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.mapper.MySkillMapper;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.MySkillEntity;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.spi.MySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.TagRepository;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Adapter
public class MySkillPersistenceAdapter implements MySkillPort {

    private final MySkillRepository mySkillRepository;

    private final TagRepository tagRepository;

    private final MySkillMapper mySkillMapper;

    public boolean existsByTagId(UUID tagId) {
        return mySkillRepository.existsByTagEntityId(tagId);
    }

    @Override
    public void saveAllMySkill(List<MySkill> mySkills) {
        List<MySkillEntity> mySkillEntities = mySkills.stream()
                .filter(m -> existsTag(m.getTagId()))
                .map(mySkillMapper::domainToEntity)
                .collect(Collectors.toList());

        mySkillRepository.saveAll(mySkillEntities);
    }

    @Override
    public List<MySkill> queryMySkillByUserId(UUID userId) {
        return mySkillRepository.findByUserId(userId).stream()
            .map(mySkillMapper::entityToDomain)
            .collect(Collectors.toList());
    }
  
    public void deleteAllMySKillByUserId(UUID userId) {
        mySkillRepository.deleteAllByUserEntityId(userId);
    }

    private boolean existsTag(UUID tagId) {
        if (!tagRepository.existsById(tagId)) {
            throw TagNotFoundException.EXCEPTION;
        }
        return true;
    }

}
