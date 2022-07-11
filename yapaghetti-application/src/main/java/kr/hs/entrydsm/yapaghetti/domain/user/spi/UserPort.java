package kr.hs.entrydsm.yapaghetti.domain.user.spi;

import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryUserPort;

public interface UserPort extends CommandUserPort, QueryUserPort, DocumentQueryUserPort, StudentQueryUserPort,
	AuthQueryUserPort {
}
