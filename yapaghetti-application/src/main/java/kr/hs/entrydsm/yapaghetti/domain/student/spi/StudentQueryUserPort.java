package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

import java.util.UUID;

public interface StudentQueryUserPort {
    User queryUserById(UUID id);
    boolean existsUserByEmail(String email);
    User queryUserByEmail(String email);
}
