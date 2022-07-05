package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DomainCreateFeedbackRequest {

    private UUID studentId;

    private Integer sequence;

    private String comment;

}
