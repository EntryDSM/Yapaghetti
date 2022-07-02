package kr.hs.entrydsm.yapaghetti.global.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GlobalErrorCode implements ErrorProperty {

    IMAGE_EXTENSION_INVALID(400, "사진의 확장자는 jpg, jpeg, png, heic이어야 합니다."),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다."),
    INVALID_TOKEN_TYPE(401, "유효하지 않은 토큰 타입입니다."),
    IMAGE_NOT_FOUND(404, "사진을 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "서버 오류");

    private final int status;
    private final String message;
}
