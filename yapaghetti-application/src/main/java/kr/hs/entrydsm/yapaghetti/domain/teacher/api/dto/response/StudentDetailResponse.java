package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class StudentDetailResponse {
    private Integer gcn;
    private String name;
    private String email;
    private String phoneNumber;
    private String majorTagName;
    private List<String> skillTagList;

    public StudentDetailResponse(String name, String email, String phoneNumber, String majorTagName,
                                 List<String> skillTagList, String grade, String classNum, Integer number) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.majorTagName = majorTagName;
        this.skillTagList = skillTagList;
        this.gcn = Integer.parseInt(grade + classNum + String.format("%02d", number));
    }

}
