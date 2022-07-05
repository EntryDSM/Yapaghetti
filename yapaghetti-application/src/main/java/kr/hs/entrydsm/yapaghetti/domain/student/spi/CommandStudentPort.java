package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;

public interface CommandStudentPort {
    void saveStudent(Student student);
}
