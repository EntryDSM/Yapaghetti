package kr.hs.entrydsm.yapaghetti.domain.user.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentQueryUserPort;

public interface UserPort extends CommandUserPort, QueryUserPort, DocumentQueryUserPort {
}
