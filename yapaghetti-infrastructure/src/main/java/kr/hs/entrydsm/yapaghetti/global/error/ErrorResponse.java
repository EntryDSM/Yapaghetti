package kr.hs.entrydsm.yapaghetti.global.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int status;
    private final String message;

    public ErrorResponse(ErrorProperty errorProperty) {
        this.status = errorProperty.getStatus();
        this.message = errorProperty.getMessage();
    }
}
