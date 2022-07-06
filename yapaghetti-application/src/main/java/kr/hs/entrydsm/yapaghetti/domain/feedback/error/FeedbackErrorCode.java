package kr.hs.entrydsm.yapaghetti.domain.feedback.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum FeedbackErrorCode implements ErrorProperty {

	FEEDBACK_NOT_FOUND(404, "피드백을 찾을 수 없음");

	private final int status;
	private final String message;
}
