package kr.hs.entrydsm.yapaghetti.domain.auth.api;

public interface SendPhoneNumberAuthCodePort {
    void execute(String phoneNumber);
}
