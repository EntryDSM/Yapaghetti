package kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DomainQueryStudentListRequest {

    private final String name = "%";
    private final String major = "%";
    private final String classNum = "%";

}
