package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import java.util.UUID;

public interface DeleteStudentPort {
    void execute(UUID studentId);
}
