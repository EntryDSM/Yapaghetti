package kr.hs.entrydsm.yapaghetti.domain.auth.mapper;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeLimit;
import kr.hs.entrydsm.yapaghetti.domain.auth.persistence.entity.AuthCodeLimitEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class AuthCodeLimitMapper {

	public AuthCodeLimitEntity domainToEntity(AuthCodeLimit authCodeLimit) {
		return AuthCodeLimitEntity.builder()
			.value(authCodeLimit.getValue())
			.type(authCodeLimit.getType())
			.timeToLive(authCodeLimit.getTimeToLive())
			.count(authCodeLimit.getCount())
			.build();
	}

	public AuthCodeLimit entityToDomain(AuthCodeLimitEntity authCodeLimitEntity) {
		return AuthCodeLimit.builder()
			.value(authCodeLimitEntity.getValue())
			.type(authCodeLimitEntity.getType())
			.timeToLive(authCodeLimitEntity.getTimeToLive())
			.count(authCodeLimitEntity.getCount())
			.build();
	}
}
