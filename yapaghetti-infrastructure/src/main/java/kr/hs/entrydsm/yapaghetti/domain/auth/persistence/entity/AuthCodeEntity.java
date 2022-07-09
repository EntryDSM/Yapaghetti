package kr.hs.entrydsm.yapaghetti.domain.auth.persistence.entity;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeType;
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
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class AuthCodeEntity {

	@Id
	private String value;

	private String authCode;

	private AuthCodeType type;

	@TimeToLive
	private Long timeToLive;

	private boolean isVerify;

}
