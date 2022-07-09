package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.GetStudentDetailPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class GetStudentDetailUseCase implements GetStudentDetailPort {

    private final TeacherCommandStudentPort teacherCommandStudentPort;

    @Override
    public StudentDetailResponse execute(UUID studentId) {
        return teacherCommandStudentPort.findNameEmailPhoneNumberMajorTagNameGradeClassNumNumberByStudentId(studentId);
    }
}
