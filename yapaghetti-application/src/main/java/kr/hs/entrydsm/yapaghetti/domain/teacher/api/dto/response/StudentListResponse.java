package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class StudentListResponse {
    private final List<StudentElementByGradeAndClassNumAndDocStatus> studentList;
}
