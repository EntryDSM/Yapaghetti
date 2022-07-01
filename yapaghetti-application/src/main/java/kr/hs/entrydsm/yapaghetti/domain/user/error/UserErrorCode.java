package kr.hs.entrydsm.yapaghetti.domain.user.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserErrorCode implements ErrorProperty {
    ;

    private final int status;
    private final String message;
}
