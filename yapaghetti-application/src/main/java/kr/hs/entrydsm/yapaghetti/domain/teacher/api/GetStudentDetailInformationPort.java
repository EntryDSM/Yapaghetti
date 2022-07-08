package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailInformationResponse;

import java.util.UUID;

public interface GetStudentDetailInformationPort {
    StudentDetailInformationResponse execute(UUID studentId);
}
