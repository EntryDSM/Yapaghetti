package kr.hs.entrydsm.yapaghetti.domain.user.spi;

import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryUserPort;

public interface UserPort extends CommandUserPort, QueryUserPort, DocumentQueryUserPort, StudentQueryUserPort, TeacherQueryUserPort, TeacherCommandUserPort, AuthQueryUserPort, StudentCommandUserPort, CompanyQueryUserPort, CompanyCommandUserPort {

}
