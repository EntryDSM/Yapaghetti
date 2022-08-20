package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.TeacherQueryStudentListPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentListResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class TeacherQueryStudentListUseCase implements TeacherQueryStudentListPort {

    private final TeacherQueryStudentPort teacherQueryStudentPort;

    @Override
    public StudentListResponse execute(Integer grade, Integer classNum, DocumentType docStatus) {
        return new StudentListResponse(
                teacherQueryStudentPort.queryStudentListByGradeAndClassNumAndDocStatus(grade, classNum, docStatus)
        );
    }

}
