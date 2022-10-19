package kr.hs.entrydsm.yapaghetti.domain.teacher.excel.exception;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ExcelErrorCode implements ErrorProperty {

    EXCEL_IO_EXCEPTION(500, "엑셀을 다운로드 할 수 없습니다.");

    private final int status;
    private final String message;
}
