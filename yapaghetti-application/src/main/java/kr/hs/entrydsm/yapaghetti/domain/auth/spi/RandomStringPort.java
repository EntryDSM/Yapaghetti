package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherRandomStringPort;

public interface RandomStringPort extends GenerateRandomStringPort, TeacherRandomStringPort,
	StudentRandomStringPort {
}
