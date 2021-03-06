package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class CompanyDetailResponse {
    private final String name;
    private final String companyId;
    private final String companyName;
    private final String phoneNumber;
    private final String email;
    private final String location;
    private final String profileImagePath;
}
