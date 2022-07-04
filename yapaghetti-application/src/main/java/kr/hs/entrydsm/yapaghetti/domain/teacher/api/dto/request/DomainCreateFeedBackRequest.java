package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class DomainCreateFeedBackRequest {
    private UUID studentId;
    private Integer sequence;
    private String content;
}
