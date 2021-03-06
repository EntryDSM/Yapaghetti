package kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence;

import java.util.List;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.MySkillEntity;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.MySkillEntityId;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MySkillRepository extends CrudRepository<MySkillEntity, MySkillEntityId> {
    List<MySkillEntity> findByUserEntityId(UUID userId);
    boolean existsByTagEntityId(UUID tagId);
    void deleteAllByUserEntityId(UUID userId);
}
