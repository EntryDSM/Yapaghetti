package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailResponse;

import java.util.UUID;

public interface GetStudentDetailPort {
    StudentDetailResponse execute(UUID studentId);
}
