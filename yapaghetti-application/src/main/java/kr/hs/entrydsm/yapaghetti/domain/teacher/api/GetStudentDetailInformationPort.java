package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailInformation;

import java.util.UUID;

public interface GetStudentDetailInformationPort {
    StudentDetailInformation execute(UUID studentId);
}
