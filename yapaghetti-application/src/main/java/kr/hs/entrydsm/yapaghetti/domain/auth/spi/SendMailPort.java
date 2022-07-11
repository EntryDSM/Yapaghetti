package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

public interface SendMailPort {
	void sendAuthCode(String email, String authCode);
}
