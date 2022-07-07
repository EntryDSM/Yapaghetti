package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;

public interface TeacherCommandStudentPort {
    void deleteStudent(Student student);
}
