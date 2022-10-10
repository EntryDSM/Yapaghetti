package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class WebDeleteFeedbackRequest {

    @NotNull
    private final UUID documentId;

    @NotNull
    private final Integer sequence;

}
