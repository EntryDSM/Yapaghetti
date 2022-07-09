package kr.hs.entrydsm.yapaghetti.domain.auth.persistence;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.mapper.AuthCodeMapper;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthCodePort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class AuthCodePersistenceAdapter implements AuthCodePort {

	private final AuthCodeRepository authCodeRepository;
	private final AuthCodeMapper authCodeMapper;

	@Override
	public void saveAuthCode(AuthCode authCode) {
		authCodeRepository.save(
			authCodeMapper.domainToEntity(authCode)
		);
	}

	@Override
	public boolean existsAuthCodeById(String id) {
		return authCodeRepository.findById(id).isPresent();
	}
}
