package kr.hs.entrydsm.yapaghetti.domain.company.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.company.exception.CompanyNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.company.mapper.CompanyMapper;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyPort;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.CompanyElement;


import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import static com.querydsl.core.types.Projections.constructor;
import static kr.hs.entrydsm.yapaghetti.domain.company.persistence.entity.QCompanyEntity.companyEntity;
import static kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.QUserEntity.userEntity;

@RequiredArgsConstructor
@Adapter
public class CompanyPersistenceAdapter implements CompanyPort {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Company queryCompanyById(UUID userId) {
        return companyMapper.entityToDomain(
                companyRepository.findByUserEntityId(userId)
                        .orElseThrow(() -> CompanyNotFoundException.EXCEPTION)
        );
    }

    @Override
    public List<CompanyElement> queryCompanyDetailList(String name) {
        return jpaQueryFactory
                .select(
                        constructor(
                                CompanyElement.class,
                                companyEntity.userId,
                                userEntity.profileImagePath,
                                companyEntity.companyName,
                                userEntity.email
                        )
                )
                .from(companyEntity)
                .where(companyEntity.companyName.contains(name))
                .join(companyEntity.userEntity, userEntity)
                .fetch();
    }

    @Override
    public void saveCompany(Company company) {
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
