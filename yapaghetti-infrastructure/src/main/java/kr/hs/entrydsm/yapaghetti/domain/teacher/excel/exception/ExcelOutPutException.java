package kr.hs.entrydsm.yapaghetti.domain.teacher.excel.exception;

import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class ExcelOutPutException extends YapaghettiException {

    public static final YapaghettiException EXCEPTION = new ExcelOutPutException();

    private ExcelOutPutException() {
        super(ExcelErrorCode.EXCEL_OUTPUT_EXCEPTION);
    }
}
