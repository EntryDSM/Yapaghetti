package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentElementByGradeAndClassNumAndDocStatus;

import java.util.List;
import java.util.UUID;

public interface TeacherQueryStudentPort {
    Student queryUserById(UUID studentId);

    List<StudentElementByGradeAndClassNumAndDocStatus> queryStudentListByGradeAndClassNumAndDocStatus(Integer grade, Integer classNum, DocumentType docStatus);
}
