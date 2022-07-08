package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryTagPort;

public interface TagPort extends CommandTagPort, QueryTagPort, StudentQueryTagPort, TeacherQueryTagPort {
}
