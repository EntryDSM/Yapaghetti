package kr.hs.entrydsm.yapaghetti.domain.teacher.exception;

import kr.hs.entrydsm.yapaghetti.domain.teacher.error.TeacherErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class TeacherInvalidRoleException extends YapaghettiException {

    private TeacherInvalidRoleException() {
        super(TeacherErrorCode.TEACHER_INVALID_ROLE);
    }

    public static final YapaghettiException EXCEPTION = new TeacherInvalidRoleException();
}
