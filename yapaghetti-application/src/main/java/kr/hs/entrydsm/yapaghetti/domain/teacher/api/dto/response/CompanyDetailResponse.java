package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class CompanyDetailResponse {
    private String name;
    private String companyId;
    private String companyName;
    private String phoneNumber;
    private String email;
    private String location;
    private String profileImagePath;
}
