package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

public interface SendSmsPort {
    void sendAuthCode(String phoneNumber, String authCode);
}
