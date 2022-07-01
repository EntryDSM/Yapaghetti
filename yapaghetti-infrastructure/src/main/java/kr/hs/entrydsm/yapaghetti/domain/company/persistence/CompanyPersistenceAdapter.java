package kr.hs.entrydsm.yapaghetti.domain.company.persistence;

import java.util.Optional;

import kr.hs.entrydsm.yapaghetti.domain.company.persistence.entity.CompanyEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyPersistenceAdapter {

	private final CompanyRepository companyRepository;

	public Optional<CompanyEntity> findCompanyByEmail(String email) {
		return companyRepository.findByUserEmail(email);
	}
}
