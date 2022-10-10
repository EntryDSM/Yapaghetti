package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class DomainDeleteFeedbackRequest {

    private final UUID documentId;

    private final Integer sequence;
}
