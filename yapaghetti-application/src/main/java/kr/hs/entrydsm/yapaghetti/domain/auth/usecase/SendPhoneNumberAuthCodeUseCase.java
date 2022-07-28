package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.SendPhoneNumberAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyTimeOutException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyVerifiedException;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GenerateRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GetAuthPropertiesPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.QueryAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendSmsPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@UseCase
public class SendPhoneNumberAuthCodeUseCase implements SendPhoneNumberAuthCodePort {

    private final QueryAuthCodePort queryAuthCodePort;
    private final CommandAuthCodePort commandAuthCodePort;
    private final GetAuthPropertiesPort getAuthPropertiesPort;
    private final GenerateRandomStringPort generateRandomStringPort;
    private final SendSmsPort sendSmsPort;

    @Override
    public void execute(String phoneNumber) {
        String authCode = generateRandomStringPort.getAuthCode();
        Long authTime = getAuthPropertiesPort.getAuthTime();
        AuthCode authCodeDomain;

        if (commandAuthCodePort.existsAuthCodeById(phoneNumber)) {
            authCodeDomain = queryAuthCodePort.queryAuthCodeById(phoneNumber)
                    .refresh(authCode, authTime);

            if (authCodeDomain.isVerify()) {
                throw AuthCodeAlreadyVerifiedException.EXCEPTION;
            }

            if (authCodeDomain.getTimeToLive() > getAuthPropertiesPort.getLimitTime()) {
                throw AuthCodeAlreadyTimeOutException.EXCEPTION;
            }
        } else {
            authCodeDomain = AuthCode.builder()
                    .value(phoneNumber)
                    .authCode(authCode)
                    .isVerify(false)
                    .timeToLive(authTime)
                    .authTime(LocalDateTime.now().plusSeconds(authTime))
                    .build();
        }

        commandAuthCodePort.saveAuthCode(authCodeDomain);

        sendSmsPort.sendAuthCode(phoneNumber, authCode);
    }
}
