package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class DomainUpdateCompanyRequest {
    private final UUID companyId;
    private final String companyName;
    private final LocalDateTime startAt;
    private final LocalDateTime endAt;
}
