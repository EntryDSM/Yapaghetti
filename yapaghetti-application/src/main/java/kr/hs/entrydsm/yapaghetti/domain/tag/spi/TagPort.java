package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryTagPort;

public interface TagPort extends CommandTagPort, QueryTagPort, StudentQueryTagPort {
}
