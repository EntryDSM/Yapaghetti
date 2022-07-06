package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyQueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagQueryStudentPort;

public interface StudentPort extends CommandStudentPort, QueryStudentPort, TagQueryStudentPort, CompanyQueryStudentPort {
}
