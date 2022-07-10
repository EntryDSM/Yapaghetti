package kr.hs.entrydsm.yapaghetti.domain.auth.mapper;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.persistence.entity.AuthCodeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class AuthCodeMapper {

	public AuthCodeEntity domainToEntity(AuthCode authCode) {
		return AuthCodeEntity.builder()
			.value(authCode.getValue())
			.authCode(authCode.getAuthCode())
			.type(authCode.getType())
			.isVerify(authCode.isVerify())
			.timeToLive(authCode.getTimeToLive())
			.build();
	}

	public AuthCode entityToDomain(AuthCodeEntity authCodeEntity) {
		return AuthCode.builder()
			.value(authCodeEntity.getValue())
			.authCode(authCodeEntity.getAuthCode())
			.type(authCodeEntity.getType())
			.timeToLive(authCodeEntity.getTimeToLive())
			.isVerify(authCodeEntity.isVerify())
			.build();
	}
}
