package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class DomainNewCompanyRequest {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String profileImagePath;
    private final String location;
    private final String companyName;
    private final LocalDateTime startAt;
    private final LocalDateTime endAt;
}
