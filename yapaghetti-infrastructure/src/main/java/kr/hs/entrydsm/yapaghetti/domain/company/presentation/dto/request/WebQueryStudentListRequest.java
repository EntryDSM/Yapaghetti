package kr.hs.entrydsm.yapaghetti.domain.company.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WebQueryStudentListRequest {

    private String name;
    private String major;
    private String classNum;

}
