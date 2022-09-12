package kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryCompanyInfoResponse {
    private final String location;
    private final String name;
    private final String phoneNumber;
}
