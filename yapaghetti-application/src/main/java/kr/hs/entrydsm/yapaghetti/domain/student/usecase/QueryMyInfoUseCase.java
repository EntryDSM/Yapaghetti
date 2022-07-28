package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.student.api.QueryMyInfoPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response.MyInfoResponse;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.QueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
public class QueryMyInfoUseCase implements QueryMyInfoPort {

    private final QueryStudentPort queryStudentPort;
    private final StudentQueryUserPort studentQueryUserPort;
    private final StudentSecurityPort studentSecurityPort;
    private final StudentQueryMySkillPort studentQueryMySkillPort;
    private final StudentQueryTagPort studentQueryTagPort;

    @Override
    public MyInfoResponse execute() {
        UUID userId = studentSecurityPort.getCurrentUserId();

        Student student = queryStudentPort.queryUserById(userId);

        User user = studentQueryUserPort.queryUserById(userId);

        List<String> skillTagList = studentQueryMySkillPort.queryMySkillByUserId(userId).stream()
                .map(mySkill -> studentQueryTagPort.queryTagById(mySkill.getTagId()))
                .map(Tag::getName)
                .collect(Collectors.toList());

        String majorTag = studentQueryTagPort.queryTagById(student.getTagId()).getName();

        return MyInfoResponse.builder()
                .grade(student.getGrade())
                .classNum(student.getClassNum())
                .number(student.getNumber())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .location(user.getLocation())
                .profileImagePath(user.getProfileImagePath())
                .skillTagList(skillTagList)
                .majorTag(majorTag)
                .build();
    }
}
