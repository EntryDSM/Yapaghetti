package kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainUpdateCompanyNameRequest {

    private final String companyName;

    private final String location;

    private final String profileImagePath;

    private final String name;

    private final String phoneNumber;

}
