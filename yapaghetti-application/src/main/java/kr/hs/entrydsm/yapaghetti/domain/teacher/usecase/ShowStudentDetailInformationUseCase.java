package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.ShowStudentDetailInformationPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailInformation;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class ShowStudentDetailInformationUseCase implements ShowStudentDetailInformationPort {

    private final TeacherQueryStudentPort teacherQueryStudentPort;
    private final TeacherQueryUserPort teacherQueryUserPort;
    private final TeacherQueryTagPort teacherQueryTagPort;
    private final TeacherQueryMySkillPort teacherQueryMySkillPort;

    @Override
    public StudentDetailInformation execute(UUID studentId) {
        Student student = teacherQueryStudentPort.queryUserById(studentId);
        User user = teacherQueryUserPort.queryUserById(student.getUserId());
        String majorTagName = teacherQueryTagPort.queryMajorTagByID(student.getTagId()).getName();
        Integer gcn = makeGcn(student.getGrade(), student.getGrade(), student.getClassNum());

        return StudentDetailInformation
                .builder()
                    .name(user.getName())
                    .phoneNumber(user.getPhoneNumber())
                    .email(user.getEmail())
                    .gcn(gcn)
                    .major(majorTagName)
                    .tagNameList(getTageNameList(user.getId()))
                .build();
    }

    private Integer makeGcn(Integer grade, Integer classNum, Integer number) {
        int gcn = (grade * 1000 + classNum * 100);

        if (10 > number) {
            gcn += number;
        }
        else {
            String formatNum = String.format("%02d", number);
            String formatGcn = Integer.toString(gcn);

            gcn = Integer.parseInt(formatGcn);
            int num = Integer.parseInt(formatNum);

            gcn += num;
        }
        return gcn;
    }

    private List<String> getTageNameList(UUID userId) {
        List<MySkill> mySkills = teacherQueryMySkillPort.queryMySkillByUserId(userId);
        List<String> mySkillNames = new ArrayList<>();
        for (MySkill mySkill: mySkills) {
            UUID tagId = mySkill.getTagId();
            mySkillNames.add(teacherQueryTagPort.queryTagById(tagId).getName());
        }
        return mySkillNames;
    }
}
