package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyQueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryDocumentPort;

public interface DocumentPort extends CommandDocumentPort, QueryDocumentPort, StudentQueryDocumentPort,
	CompanyQueryDocumentPort {
}
