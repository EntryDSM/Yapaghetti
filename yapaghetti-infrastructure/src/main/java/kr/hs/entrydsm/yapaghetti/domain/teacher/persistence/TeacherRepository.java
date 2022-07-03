package kr.hs.entrydsm.yapaghetti.domain.teacher.persistence;

import kr.hs.entrydsm.yapaghetti.domain.teacher.persistence.entity.TeacherEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeacherRepository extends CrudRepository<TeacherEntity, UUID> {
}
