package kr.hs.entrydsm.yapaghetti.domain.company.mapper;

import kr.hs.entrydsm.yapaghetti.domain.company.domain.Company;
import kr.hs.entrydsm.yapaghetti.domain.company.persistence.entity.CompanyEntity;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.UserPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.UserRepository;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CompanyMapper {

    private final UserRepository userRepository;

    public Company entityToDomain(CompanyEntity company) {
        return Company.builder()
                .userId(company.getUserId())
                .companyName(company.getCompanyName())
                .startAt(company.getStartAt())
                .endAt(company.getEndAt())
                .build();
    }

    public CompanyEntity domainToEntity(Company company) {
        UserEntity user = userRepository.findById(company.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        return CompanyEntity.builder()
                .userId(user.getId())
                .userEntity(user)
                .startAt(company.getStartAt())
                .endAt(company.getEndAt())
                .companyName(company.getCompanyName())
                .build();
    }

}
