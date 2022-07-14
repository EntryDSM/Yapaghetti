package kr.hs.entrydsm.yapaghetti.domain.auth.api;

public interface VerifyAuthCodePort {
	void execute(String authCode, String value);
}
