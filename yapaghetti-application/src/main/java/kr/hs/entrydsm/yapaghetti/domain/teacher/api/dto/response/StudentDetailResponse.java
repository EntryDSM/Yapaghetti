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

    public StudentDetailResponse(StudentInformation personalAndMajorResponse,
                                 List<String> mySkillNameList) {
        this.name = personalAndMajorResponse.getName();
        this.gcn = personalAndMajorResponse.getGcn();
        this.profileImagePath = personalAndMajorResponse.getProfileImagePath();
        this.email = personalAndMajorResponse.getProfileImagePath();
        this.phoneNumber = personalAndMajorResponse.getPhoneNumber();
        this.majorTagName = personalAndMajorResponse.getMajorTagName();
        this.mySkillNameList = mySkillNameList;
    }
}
