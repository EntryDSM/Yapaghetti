package kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class StudentElement {

    private final UUID studentId;

    private final String major;

    private final List<String> tagList;

    private final String name;

    private final String gcn;

    private final String previewImagePath;

    public StudentElement(UUID studentId, String major, List<String> tagList, String name, String grade, String classNum, Integer number, String previewImagePath, String profileImagePath) {
        this.studentId = studentId;
        this.major = major;
        this.tagList = tagList;
        this.name = name;
        this.gcn = grade + classNum + String.format("%02d", number);
        this.previewImagePath = previewImagePath;
        this.profileImagePath = profileImagePath;
    }

    private final String profileImagePath;

}
