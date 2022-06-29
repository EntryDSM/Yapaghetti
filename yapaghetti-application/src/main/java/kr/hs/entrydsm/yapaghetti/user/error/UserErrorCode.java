package kr.hs.entrydsm.yapaghetti.user.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ErrorProperty {
    ;

    private final int status;
    private final String message;
}
