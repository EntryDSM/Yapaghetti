package kr.hs.entrydsm.yapaghetti.domain.user.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Aggregate
public class RefreshToken {

    private final String id;

    private final String refreshToken;

    private final Long ttl;

    public RefreshToken update(String refreshToken, Long ttl) {
        return RefreshToken.builder()
                .id(this.id)
                .refreshToken(refreshToken)
                .ttl(ttl)
                .build();
    }

}
