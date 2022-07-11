package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.QueryStudentDetailPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailInformation;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class QueryStudentDetailUseCase implements QueryStudentDetailPort {

    private final TeacherQueryStudentPort teacherQueryStudentPort;

    @Override
    public StudentDetailResponse execute(UUID studentId) {
        StudentDetailInformation studentInformation = teacherQueryStudentPort.queryStudentDetail(studentId);

        return StudentDetailResponse.builder()
                .name(studentInformation.getName())
                .gcn(makeGcn(
                        studentInformation.getGrade(),
                        studentInformation.getClassNum(),
                        studentInformation.getNumber()
                ))
                .email(studentInformation.getEmail())
                .phoneNumber(studentInformation.getPhoneNumber())
                .majorTagName(studentInformation.getMajorTagName())
                .mySkillNameList(studentInformation.getMySkillNameList())
                .build();
    }

    private Integer makeGcn(String grade, String classNum, Integer number) {
        return Integer.parseInt(grade + classNum + String.format("%02d",number));
    }
}
