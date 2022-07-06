package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
public class DomainCreateFeedbackRequest {

    private UUID studentId;

    private Integer sequence;

    private String comment;

}
