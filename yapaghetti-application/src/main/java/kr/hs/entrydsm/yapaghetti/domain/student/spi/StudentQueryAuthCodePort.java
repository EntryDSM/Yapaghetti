package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;

public interface StudentQueryAuthCodePort {
	AuthCode queryAuthCodeById(String id);
}
