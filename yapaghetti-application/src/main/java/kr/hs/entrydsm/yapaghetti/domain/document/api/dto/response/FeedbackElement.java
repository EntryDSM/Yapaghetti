package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FeedbackElement {

    private final Integer sequence;

    private final String comment;

    private final boolean isApply;

}
