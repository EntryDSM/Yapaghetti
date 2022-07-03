package kr.hs.entrydsm.yapaghetti.domain.image.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ImageErrorCode implements ErrorProperty {

    IMAGE_EXTENSION_INVALID(400, "사진의 확장자는 jpg, jpeg, png, heic이어야 합니다."),
    IMAGE_NOT_FOUND(404, "사진을 찾을 수 없습니다.");

    private final int status;
    private final String message;
}
