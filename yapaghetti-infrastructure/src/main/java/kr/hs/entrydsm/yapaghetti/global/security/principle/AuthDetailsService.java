package kr.hs.entrydsm.yapaghetti.global.security.principle;

import kr.hs.entrydsm.yapaghetti.domain.user.company.persistence.CompanyPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.user.company.persistence.entity.CompanyAuthority;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.UserPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserRole;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import kr.hs.entrydsm.yapaghetti.global.security.SecurityRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

	private final UserPersistenceAdapter userPersistenceAdapter;
	private final CompanyPersistenceAdapter companyPersistenceAdapter;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity user = userPersistenceAdapter.findUserByEmail(username)
			.orElseThrow(); //TODO Auth 담당자 분이 넣어주세요

		SecurityRole role =  SecurityRole.valueOf(user.getRole().name());

		if(UserRole.COMPANY.equals(user.getRole())) {

			CompanyAuthority authority = companyPersistenceAdapter.findCompanyByEmail(username)
				.orElseThrow() //TODO Auth 담당자 분이 넣어주세요
				.getAuthority();

			role = SecurityRole.valueOf(authority.name());
		}

		return new AuthDetails(username, role);
	}
}
