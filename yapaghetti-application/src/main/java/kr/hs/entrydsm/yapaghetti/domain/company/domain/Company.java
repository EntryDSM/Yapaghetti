package kr.hs.entrydsm.yapaghetti.domain.company.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Aggregate
public class Company {

    private final UUID userId;

    private final String companyName;

    private final LocalDateTime startAt;

    private final LocalDateTime endAt;

    public Company updateCompanyName(String companyName) {
        return Company.builder()
                .userId(this.userId)
                .companyName(companyName)
                .startAt(this.startAt)
                .endAt(this.endAt)
                .build();
    }

}
