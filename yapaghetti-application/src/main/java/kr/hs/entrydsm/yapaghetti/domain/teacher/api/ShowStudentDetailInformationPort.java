package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailInformation;

import java.util.UUID;

public interface ShowStudentDetailInformationPort {
    StudentDetailInformation execute(UUID studentId);
}
