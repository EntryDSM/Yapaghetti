package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import java.util.List;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.SendEmailAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.api.dto.response.SendEmailAuthCodeResponse;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.enums.EmailType;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyVerifiedException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeOverLimitException;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GenerateRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GetAuthPropertiesPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.QueryAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@UseCase
public class SendEmailAuthCodeUseCase implements SendEmailAuthCodePort {

    private final AuthSecurityPort authSecurityPort;
    private final AuthQueryUserPort authQueryUserPort;
    private final GenerateRandomStringPort generateRandomStringPort;
    private final SendMailPort sendMailPort;
    private final QueryAuthCodePort queryAuthCodePort;
    private final CommandAuthCodePort commandAuthCodePort;
    private final GetAuthPropertiesPort getAuthPropertiesPort;

    @Override
    public SendEmailAuthCodeResponse execute() {
        Long authTime = getAuthPropertiesPort.getAuthTime();
        String authCode = generateRandomStringPort.getAuthCode();
        AuthCode emailAuthCode;

        User user = authQueryUserPort.queryUserById(
                authSecurityPort.getCurrentUserId()
        );
        String value = user.getEmail();

        if (commandAuthCodePort.existsAuthCodeById(value)) {
            emailAuthCode = queryAuthCodePort.queryAuthCodeById(value)
                    .refresh(authCode, authTime);

            if (emailAuthCode.isVerify()) {
                throw AuthCodeAlreadyVerifiedException.EXCEPTION;
            }

            if (emailAuthCode.getTimeToLive() > getAuthPropertiesPort.getLimitTime()) {
                throw AuthCodeOverLimitException.EXCEPTION;
            }
        } else {
            emailAuthCode = AuthCode.builder()
                    .value(value)
                    .authCode(authCode)
                    .isVerify(false)
                    .timeToLive(authTime)
                    .authTime(LocalDateTime.now().plusSeconds(authTime))
                    .build();
        }

        commandAuthCodePort.saveAuthCode(emailAuthCode);

        List<String> values = List.of(authCode);
        sendMailPort.sendAuthCode(value, values, EmailType.CERTIFICATION_EMAIL);

        return new SendEmailAuthCodeResponse(value);
    }
}
