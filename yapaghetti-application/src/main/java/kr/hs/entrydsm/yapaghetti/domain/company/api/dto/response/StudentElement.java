package kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class StudentElement {

    private final UUID studentId;

    private final String majorTag;

    private final List<String> skillTagList;

    private final String name;

    private final String gcn;
    private final UUID publicDocumentId;

    private final String previewImagePath;

    private final String profileImagePath;

    public StudentElement(UUID studentId, String majorTag, List<String> skillTagList, String name, String grade, String classNum, Integer number, UUID publicDocumentId, String previewImagePath, String profileImagePath) {
        this.studentId = studentId;
        this.majorTag = majorTag;
        this.skillTagList = skillTagList;
        this.name = name;
        this.gcn = grade + classNum + String.format("%02d", number);
        this.publicDocumentId = publicDocumentId;
        this.previewImagePath = previewImagePath;
        this.profileImagePath = profileImagePath;
    }

}
