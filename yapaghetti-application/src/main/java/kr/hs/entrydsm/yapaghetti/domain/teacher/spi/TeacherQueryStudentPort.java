package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailResponse;

import java.util.UUID;

public interface TeacherQueryStudentPort {
    Student queryUserById(UUID studentId);
    StudentDetailResponse findNameEmailPhoneNumberMajorTagNameGradeClassNumNumberByStudentId(UUID studentId);
}
