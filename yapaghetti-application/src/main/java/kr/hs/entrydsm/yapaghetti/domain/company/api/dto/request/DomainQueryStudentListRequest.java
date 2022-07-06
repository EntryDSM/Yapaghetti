package kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainQueryStudentListRequest {

    private String name = "%";
    private String major = "%";
    private String classNum = "%";

}
