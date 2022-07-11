package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;

import java.util.UUID;

public interface DocumentQueryStudentPort {
    Student queryStudentById(UUID studentId);
}
