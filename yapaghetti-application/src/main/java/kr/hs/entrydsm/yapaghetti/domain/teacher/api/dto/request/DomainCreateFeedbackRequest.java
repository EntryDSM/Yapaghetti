package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class DomainCreateFeedbackRequest {
    private final UUID studentId;
    private final Integer sequence;
    private final String content;
}
