package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StudentListResponse {
    private final List<StudentElementByGradeAndClassNumAndDocStatus> studentList;
}
