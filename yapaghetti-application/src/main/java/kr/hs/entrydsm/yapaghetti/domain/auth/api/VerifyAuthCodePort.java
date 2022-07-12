package kr.hs.entrydsm.yapaghetti.domain.auth.api;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeType;

public interface VerifyAuthCodePort {
	void execute(String authCode, AuthCodeType type);
}
