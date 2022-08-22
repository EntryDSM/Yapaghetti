package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Getter;

import java.util.UUID;

@Getter
public class StudentElementByGradeClassNum {
    private final UUID studentId;
    private final String name;
    private final String gcn;
    private final String profileImagePath;
    private final boolean feedbackStatus;
    private final boolean isRejected;
    private final boolean publicStatus;


    public StudentElementByGradeClassNum(UUID studentId, String name, String profileImagePath,
                                         String grade, String classNum, Integer number,
                                         Boolean feedbackStatus,Boolean stayExist, Boolean isRejected,
                                         Boolean publicExist
    ) {
        this.studentId = studentId;
        this.name = name;
        this.gcn = grade + classNum + String.format("%02d", number);
        this.profileImagePath = profileImagePath;
        this.feedbackStatus = feedbackStatus;
        this.isRejected = stayExist && isRejected;
        this.publicStatus = publicExist;
    }
}
