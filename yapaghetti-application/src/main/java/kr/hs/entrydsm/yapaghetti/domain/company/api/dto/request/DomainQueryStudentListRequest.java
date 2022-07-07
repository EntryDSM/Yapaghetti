package kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request;

import lombok.Getter;

@Getter
public class DomainQueryStudentListRequest {

    private final String name;
    private final String major;
    private final String classNum;

    public DomainQueryStudentListRequest(String name, String major, String classNum) {
        this.name = nullCheck(name);
        this.major = nullCheck(major);
        this.classNum = nullCheck(classNum);
    }

    private String nullCheck(String value) {
        return value != null ? value : "%";
    }


}
