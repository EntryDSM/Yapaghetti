package kr.hs.entrydsm.yapaghetti.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class YapaghettiException extends RuntimeException {

    private final ErrorProperty errorProperty;
}
