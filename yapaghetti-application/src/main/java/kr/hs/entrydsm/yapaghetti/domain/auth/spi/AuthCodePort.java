package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryAuthCodePort;

public interface AuthCodePort extends QueryAuthCodePort, CommandAuthCodePort,
	StudentQueryAuthCodePort {
}
