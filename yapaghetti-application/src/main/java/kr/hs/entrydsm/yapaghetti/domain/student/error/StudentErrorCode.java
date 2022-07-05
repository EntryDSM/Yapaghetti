package kr.hs.entrydsm.yapaghetti.domain.student.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum StudentErrorCode implements ErrorProperty {
	STUDENT_NOT_FOUND(404, "학생을 찾을 수 없습니다.");

	private final int status;
	private final String message;
}
