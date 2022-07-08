package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentDetailInformation {
    private String name;
    private String email;
    private String phoneNumber;
    private Integer gcn;
    private String major;
    private List<String> tagNameList;
}
