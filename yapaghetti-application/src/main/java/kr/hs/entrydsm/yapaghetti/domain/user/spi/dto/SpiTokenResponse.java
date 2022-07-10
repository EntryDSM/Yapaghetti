package kr.hs.entrydsm.yapaghetti.domain.user.spi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpiTokenResponse {

    private final String accessToken;
    private final String refreshToken;
    private final Long refreshExp;

}
