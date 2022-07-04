package kr.hs.entrydsm.yapaghetti.domain.feedback.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class FeedBack {

    private final Integer sequence;

    private final UUID documentId;

    private final String content;

    private final boolean isApply;

}
