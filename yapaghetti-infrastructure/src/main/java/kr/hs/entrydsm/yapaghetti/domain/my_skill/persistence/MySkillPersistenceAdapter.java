package kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.mapper.MySkillMapper;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.MySkillEntity;
import static kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.QMySkillEntity.mySkillEntity;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.spi.MySkillPort;
import static kr.hs.entrydsm.yapaghetti.domain.student.persistence.entity.QStudentEntity.studentEntity;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.TagRepository;

import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.QTagEntity;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Adapter
public class MySkillPersistenceAdapter implements MySkillPort {

    private final MySkillRepository mySkillRepository;

    private final MySkillMapper mySkillMapper;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public boolean existsMySkillByTagId(UUID tagId) {
        return mySkillRepository.existsByTagEntityId(tagId);
    }

    @Override
    public void saveAllMySkill(List<MySkill> mySkills) {
        List<MySkillEntity> mySkillEntities = mySkills.stream()
                .map(mySkillMapper::domainToEntity)
                .collect(Collectors.toList());

        mySkillRepository.saveAll(mySkillEntities);
    }

    @Override
    public List<MySkill> queryMySkillByUserId(UUID userId) {
        return mySkillRepository.findByUserEntityId(userId).stream()
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

    @Override
    public List<String> queryMySkillNameByStudentId(UUID studentId) {
        QTagEntity skillTag = new QTagEntity("skillTag");

        return jpaQueryFactory
                .select(skillTag.name)
                .from(studentEntity)
                .where(studentEntity.userId.eq(studentId))
                .leftJoin(studentEntity.mySkillList, mySkillEntity)
                .leftJoin(mySkillEntity.tagEntity, skillTag)
                .fetch();
    }

}
