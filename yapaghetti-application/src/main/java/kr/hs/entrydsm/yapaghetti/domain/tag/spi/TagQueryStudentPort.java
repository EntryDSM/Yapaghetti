package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;

import java.util.UUID;

public interface TagQueryStudentPort {
    Student queryUserById(UUID id);
}
