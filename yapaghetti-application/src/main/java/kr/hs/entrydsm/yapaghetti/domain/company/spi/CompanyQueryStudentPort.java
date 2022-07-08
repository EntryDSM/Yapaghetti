package kr.hs.entrydsm.yapaghetti.domain.company.spi;

import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response.StudentElement;

import java.util.List;

public interface CompanyQueryStudentPort {
    List<StudentElement> findStudentByNameAndMajorAndClassNum(String name, String major, String classNum);
}
