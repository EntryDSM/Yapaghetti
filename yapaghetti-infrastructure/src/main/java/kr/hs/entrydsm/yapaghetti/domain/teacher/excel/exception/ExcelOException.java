package kr.hs.entrydsm.yapaghetti.domain.teacher.excel.exception;

import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class ExcelOException extends YapaghettiException {

    public static final YapaghettiException EXCEPTION = new ExcelOException();

    private ExcelOException() {
        super(ExcelErrorCode.EXCEL_IO_EXCEPTION);
    }
}
