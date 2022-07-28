package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class StudentDetailResponse {
    private final String name;
    private final Integer gcn;
    private final String email;
    private final String phoneNumber;
    private final String majorTagName;
    private final List<String> mySkillNameList;

    public StudentDetailResponse(String name, String grade, String classNum, Integer number, String email,
                                 String phoneNumber, String majorTagName, List<String> mySkillNameList) {
        this.name = name;
        this.gcn = Integer.parseInt(grade + classNum + String.format("%2d", number));
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.majorTagName = majorTagName;
        this.mySkillNameList = mySkillNameList;
    }
}
