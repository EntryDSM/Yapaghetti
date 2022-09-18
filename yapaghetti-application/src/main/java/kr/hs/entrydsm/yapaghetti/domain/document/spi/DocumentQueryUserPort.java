package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

import java.util.UUID;

public interface DocumentQueryUserPort {
    User queryUserById(UUID id);
    String getTeacherEmail();
}
