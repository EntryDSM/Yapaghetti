package kr.hs.entrydsm.yapaghetti.domain.document.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DocumentErrorCode implements ErrorProperty {

    DOCUMENT_NOT_FOUND(404, "문서를 찾을 수 없습니다.");

    private final int status;
    private final String message;
}
