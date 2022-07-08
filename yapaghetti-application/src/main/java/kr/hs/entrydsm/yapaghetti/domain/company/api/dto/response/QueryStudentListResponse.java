package kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryStudentListResponse {

    private final List<StudentElement> studentList;

}
