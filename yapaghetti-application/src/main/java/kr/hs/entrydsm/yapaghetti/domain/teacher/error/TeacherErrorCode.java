package kr.hs.entrydsm.yapaghetti.domain.teacher.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TeacherErrorCode implements ErrorProperty {

    TEACHER_INVALID_ROLE(401, "잘못된 역할입니다."),
    TEACHER_FORBIDDEN(403, "권한이 존재하지 않습니다");

    private final int status;
    private final String message;
}
