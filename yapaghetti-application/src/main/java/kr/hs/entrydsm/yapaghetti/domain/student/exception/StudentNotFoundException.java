package kr.hs.entrydsm.yapaghetti.domain.student.exception;

import kr.hs.entrydsm.yapaghetti.domain.student.error.StudentErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class StudentNotFoundException extends YapaghettiException {

    public static final StudentNotFoundException EXCEPTION = new StudentNotFoundException();

    private StudentNotFoundException() {
        super(StudentErrorCode.STUDENT_NOT_FOUND);
    }

}
