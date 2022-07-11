package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeType;

public interface QueryAuthCodePort {
	AuthCode queryAuthCodeByValueAndType(String id, AuthCodeType authCodeType);
}
