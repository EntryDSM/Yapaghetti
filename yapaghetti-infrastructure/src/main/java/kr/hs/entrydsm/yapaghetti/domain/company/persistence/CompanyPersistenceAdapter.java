package kr.hs.entrydsm.yapaghetti.domain.company.persistence;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.company.exception.CompanyNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.company.mapper.CompanyMapper;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CommandCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.QueryCompanyPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class CompanyPersistenceAdapter implements CompanyPort {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public Company queryCompanyById(UUID userId) {
        return companyMapper.entityToDomain(
                companyRepository.findByUserEntityId(userId)
                        .orElseThrow(() -> CompanyNotFoundException.EXCEPTION)
        );
    }

    @Override
    public void updateCompany(Company company) {
        companyRepository.save(companyMapper.domainToEntity(company));
    }

    @Override
    public void deleteCompany(Company company) {
        companyRepository.delete(
                companyMapper.domainToEntity(
                        company
                )
        );
    }
}
