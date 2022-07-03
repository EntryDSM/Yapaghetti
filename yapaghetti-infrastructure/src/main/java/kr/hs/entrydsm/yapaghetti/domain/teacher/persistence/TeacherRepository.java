package kr.hs.entrydsm.yapaghetti.domain.teacher.persistence;

import kr.hs.entrydsm.yapaghetti.domain.teacher.persistence.entity.TeacherEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<TeacherEntity, Long> {
}
