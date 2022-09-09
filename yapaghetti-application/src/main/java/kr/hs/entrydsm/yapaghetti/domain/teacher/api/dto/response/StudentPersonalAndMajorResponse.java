package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Getter;

@Getter
public class StudentPersonalAndMajorResponse {
    private final String name;
    private final String gcn;
    private final String email;
    private final String profileImagePath;
    private final String phoneNumber;
    private final String majorTagName;

    public StudentPersonalAndMajorResponse(String name, String grade, String classNum, Integer number, String profileImagePath,
                                 String email, String phoneNumber, String majorTagName) {
        this.name = name;
        this.gcn = grade + classNum + String.format("%02d", number);
        this.profileImagePath = profileImagePath;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.majorTagName = majorTagName;
    }
}
