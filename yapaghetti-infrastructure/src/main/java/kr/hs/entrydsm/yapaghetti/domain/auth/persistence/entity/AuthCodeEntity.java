package kr.hs.entrydsm.yapaghetti.domain.auth.persistence.entity;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class AuthCodeEntity {

	@Id
	private String value;

	private String authCode;

	@TimeToLive
	private Long timeToLive;

	private LocalDateTime authTime;

	private boolean isVerify;

}
