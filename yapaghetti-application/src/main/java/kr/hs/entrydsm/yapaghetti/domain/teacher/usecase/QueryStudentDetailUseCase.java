package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.QueryStudentDetailPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentInformation;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@ReadOnlyUseCase
public class QueryStudentDetailUseCase implements QueryStudentDetailPort {

    private final TeacherQueryStudentPort teacherQueryStudentPort;

    private final TeacherQueryMySkillPort teacherQueryMySkillPort;

    @Override
    public StudentDetailResponse execute(UUID studentId) {

        StudentInformation studentInformation =
                teacherQueryStudentPort.queryPersonalAndMajorById(studentId);

        List<String> mySkillNameList = teacherQueryMySkillPort.queryMySkillNameByStudentId(studentId);

        mySkillNameList = mySkillNameList.get(0) == null ? null : mySkillNameList;

        return new StudentDetailResponse(
                studentInformation,
                mySkillNameList
        );
    }

}
