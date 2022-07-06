package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import java.util.UUID;

public interface TeacherSecurityPort {
    UUID getCurrentUserId();
}
