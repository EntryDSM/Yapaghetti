package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class DomainUpdateCompanyRequest {
    private UUID companyId;
    private String companyName;
    private String location;
    private String phoneNumber;
    private String name;
    private String email;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
