package kr.hs.entrydsm.yapaghetti.domain.teacher.exception;

import kr.hs.entrydsm.yapaghetti.domain.teacher.error.TeacherErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class TeacherForbiddenException extends YapaghettiException {

    private TeacherForbiddenException() {
        super(TeacherErrorCode.TEACHER_FORBIDDEN);
    }

    public static final YapaghettiException EXCEPTION = new TeacherForbiddenException();

}
