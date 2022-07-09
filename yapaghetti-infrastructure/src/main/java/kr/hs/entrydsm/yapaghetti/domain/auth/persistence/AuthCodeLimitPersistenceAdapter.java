package kr.hs.entrydsm.yapaghetti.domain.auth.persistence;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeLimit;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeLimitNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.auth.mapper.AuthCodeLimitMapper;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthCodeLimitPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class AuthCodeLimitPersistenceAdapter implements AuthCodeLimitPort {

	private final AuthCodeLimitRepository authCodeLimitRepository;
	private final AuthCodeLimitMapper authCodeLimitMapper;

	@Override
	public void saveAuthCodeLimit(AuthCodeLimit authCodeLimit) {
		authCodeLimitRepository.save(
			authCodeLimitMapper.domainToEntity(authCodeLimit)
		);
	}

	@Override
	public AuthCodeLimit queryAuthCodeLimitById(String id) {
		return authCodeLimitMapper.entityToDomain(
			authCodeLimitRepository.findById(id)
				.orElseThrow(() -> AuthCodeLimitNotFoundException.EXCEPTION)
		);
	}
}
