package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;

import java.util.UUID;

public interface QueryStudentPort {
    Student findById(UUID id);
}
