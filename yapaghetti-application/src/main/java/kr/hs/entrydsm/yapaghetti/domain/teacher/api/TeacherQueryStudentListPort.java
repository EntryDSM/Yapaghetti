package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentListResponse;

public interface TeacherQueryStudentListPort {
    StudentListResponse execute(Integer grade, Integer classNum, DocumentType docStatus);
}
