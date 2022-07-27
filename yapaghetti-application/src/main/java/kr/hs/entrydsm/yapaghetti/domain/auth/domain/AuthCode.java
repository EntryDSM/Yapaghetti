package kr.hs.entrydsm.yapaghetti.domain.auth.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@Aggregate
public class AuthCode {

    private final String value;

    private final String authCode;

    private final Long timeToLive;

    private final LocalDateTime authTime;

    private final boolean isVerify;

    public AuthCode refresh(String authCode, Long authTime) {
        return AuthCode.builder()
                .value(this.getValue())
                .authCode(authCode)
                .timeToLive(timeToLive + authTime)
                .authTime(LocalDateTime.now().plusSeconds(authTime))
                .isVerify(this.isVerify)
                .build();
    }

    public AuthCode verify() {
        return AuthCode.builder()
                .value(this.getValue())
                .authCode(this.authCode)
                .timeToLive(this.timeToLive)
                .authTime(this.getAuthTime())
                .isVerify(true)
                .build();
    }
}
