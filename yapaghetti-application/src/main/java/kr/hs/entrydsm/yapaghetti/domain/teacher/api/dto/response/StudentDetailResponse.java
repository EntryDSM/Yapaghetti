package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class StudentDetailResponse {
    private final String name;
    private final String gcn;
    private final String email;
    private final String profileImagePath;
    private final String phoneNumber;
    private final String majorTagName;
    private final List<String> mySkillNameList;

    public StudentDetailResponse(StudentInformation studentInformation,
                                 List<String> mySkillNameList) {
        this.name = studentInformation.getName();
        this.gcn = studentInformation.getGcn();
        this.profileImagePath = studentInformation.getProfileImagePath();
        this.email = studentInformation.getEmail();
        this.phoneNumber = studentInformation.getPhoneNumber();
        this.majorTagName = studentInformation.getMajorTagName();
        this.mySkillNameList = mySkillNameList;
    }
}
