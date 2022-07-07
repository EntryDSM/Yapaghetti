package kr.hs.entrydsm.yapaghetti.domain.company.mapper;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.company.persistence.entity.CompanyEntity;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.UserPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CompanyMapper {

    private final UserPersistenceAdapter userPersistenceAdapter;

    public Company entityToDomain(CompanyEntity company) {
        return Company.builder()
                .userId(company.getUserId())
                .companyName(company.getCompanyName())
                .build();
    }

    public CompanyEntity domainToEntity(Company company) {
        UserEntity user = userPersistenceAdapter.findUserById(company.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        return CompanyEntity.builder()
                .userEntity(user)
                .companyName(company.getCompanyName())
                .build();
    }

}
