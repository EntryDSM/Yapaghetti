package kr.hs.entrydsm.yapaghetti.domain.student.persistence;

import kr.hs.entrydsm.yapaghetti.domain.student.persistence.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StudentRepository extends CrudRepository<StudentEntity, UUID> {

    boolean existsByTagEntityId(UUID tagId);
}
