package kr.hs.entrydsm.yapaghetti.domain.tag.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TagErrorCode implements ErrorProperty {

    ALREADY_EXISTS_TAG(409, "이미 존재하는 태그입니다.");

    private final int status;
    private final String message;

}
