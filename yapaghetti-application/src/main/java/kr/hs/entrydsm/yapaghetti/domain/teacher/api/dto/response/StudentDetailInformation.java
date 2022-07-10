package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class StudentDetailInformation {
    private final String name;
    private final String grade;
    private final String classNum;
    private final Integer number;
    private final String email;
    private final String phoneNumber;
    private final String majorTagName;
    private final List<String> mySkillNameList;
}
