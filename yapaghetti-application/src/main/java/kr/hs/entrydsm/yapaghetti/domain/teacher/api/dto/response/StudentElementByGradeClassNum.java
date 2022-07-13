package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Getter;

@Getter
public class StudentElementByGradeClassNum {
    private final String studentId;
    private final String name;
    private final Integer gcn;
    private final String profileImageName;
    private final boolean feedbackStatus;
    private final boolean publicStatus;
    private final boolean isApproved;

    public StudentElementByGradeClassNum(String studentId, String name, String profileImageName,
                                         String grade, String classNum, Integer number,
                                         boolean feedbackStatus, boolean publicStatus, boolean isApproved) {
        this.studentId = studentId;
        this.name = name;
        this.gcn = Integer.parseInt(grade + classNum + String.format("%02d", number));
        this.profileImageName = profileImageName;
        this.feedbackStatus = feedbackStatus;
        this.publicStatus = publicStatus;
        this.isApproved = isApproved;
    }
}
