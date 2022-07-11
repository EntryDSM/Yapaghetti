package kr.hs.entrydsm.yapaghetti.domain.auth.api;

public interface VerifyEmailAuthCodePort {
	void execute(String authCode);
}
