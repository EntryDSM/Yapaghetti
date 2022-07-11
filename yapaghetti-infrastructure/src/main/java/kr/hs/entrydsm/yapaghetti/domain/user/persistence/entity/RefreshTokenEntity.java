package kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Builder
@RedisHash
public class RefreshTokenEntity {

    @Id
    private final String id;

    @Indexed
    private String refreshToken;

    @TimeToLive
    private Long ttl;

}
