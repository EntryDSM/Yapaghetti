package kr.hs.entrydsm.yapaghetti.domain.student;

import kr.hs.entrydsm.yapaghetti.domain.student.persistence.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

}
