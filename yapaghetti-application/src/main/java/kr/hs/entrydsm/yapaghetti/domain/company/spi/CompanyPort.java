package kr.hs.entrydsm.yapaghetti.domain.company.spi;

import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryCompanyPort;

public interface CompanyPort extends CommandCompanyPort, QueryCompanyPort, TeacherQueryCompanyPort, TeacherCommandCompanyPort {
}
