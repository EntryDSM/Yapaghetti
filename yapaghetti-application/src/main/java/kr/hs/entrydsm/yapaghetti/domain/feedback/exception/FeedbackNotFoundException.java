package kr.hs.entrydsm.yapaghetti.domain.feedback.exception;

import kr.hs.entrydsm.yapaghetti.domain.feedback.error.FeedbackErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class FeedbackNotFoundException extends YapaghettiException {

    private FeedbackNotFoundException() {
        super(FeedbackErrorCode.FEEDBACK_NOT_FOUND);
    }

    public static final YapaghettiException EXCEPTION = new FeedbackNotFoundException();

}