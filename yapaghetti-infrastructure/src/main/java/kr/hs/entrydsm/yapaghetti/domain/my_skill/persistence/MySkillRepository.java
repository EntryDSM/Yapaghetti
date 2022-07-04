package kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.MySkillEntity;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.MySkillEntityId;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MySkillRepository extends CrudRepository<MySkillEntity, MySkillEntityId> {
    boolean existsByTagId(UUID tagId);
}
