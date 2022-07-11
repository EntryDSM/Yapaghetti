package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;

public interface CommandAuthCodePort {
	void saveAuthCode(AuthCode authCode);
	boolean existsAuthCodeById(String id);
}
