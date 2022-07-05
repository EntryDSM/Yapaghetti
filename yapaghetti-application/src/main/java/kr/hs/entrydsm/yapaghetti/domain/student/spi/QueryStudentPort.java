package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;

public interface QueryStudentPort {
	Student queryUserById(UUID id);
}
