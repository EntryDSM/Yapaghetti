package kr.hs.entrydsm.yapaghetti.global.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements ErrorProperty {

    INTERNAL_SERVER_ERROR(500, "서버 오류");

    private final int status;
    private final String message;
}
