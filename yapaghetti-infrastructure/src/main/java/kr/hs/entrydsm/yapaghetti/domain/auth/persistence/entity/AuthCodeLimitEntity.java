package kr.hs.entrydsm.yapaghetti.domain.auth.persistence.entity;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class AuthCodeLimitEntity {

	@Id
	private String value;

	private AuthCodeType type;

	private long timeToLive;

	private int count;
}
