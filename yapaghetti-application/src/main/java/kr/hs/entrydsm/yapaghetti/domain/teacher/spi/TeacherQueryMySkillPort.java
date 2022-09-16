package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import java.util.List;
import java.util.UUID;

public interface TeacherQueryMySkillPort {

    List<String> queryMySkillNameByStudentId(UUID studentId);

}
