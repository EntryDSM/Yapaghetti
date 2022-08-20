package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.QueryStudentDetailPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class QueryStudentDetailUseCase implements QueryStudentDetailPort {

    private final TeacherQueryStudentPort teacherQueryStudentPort;

    @Override
    public StudentDetailResponse execute(UUID studentId) {
        return teacherQueryStudentPort.queryStudentDetail(studentId);
    }

}
