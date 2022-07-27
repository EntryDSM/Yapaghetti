package kr.hs.entrydsm.yapaghetti.domain.tag.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TagErrorCode implements ErrorProperty {

    UNABLE_DELETE_TAG(400, "사용하고 있는 태그는 삭제할 수 없습니다."),
    TAG_NOT_FOUND(404, "태그를 찾을 수 없습니다."),
    ALREADY_EXISTS_TAG(409, "이미 존재하는 태그입니다.");

    private final int status;
    private final String message;

}
