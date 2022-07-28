package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import java.util.UUID;

public interface StudentSecurityPort {
    UUID getCurrentUserId();
}
