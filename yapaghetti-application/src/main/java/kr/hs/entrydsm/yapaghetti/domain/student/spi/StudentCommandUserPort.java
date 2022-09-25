package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

import java.util.UUID;

public interface StudentCommandUserPort {
    void saveUser(User user);

    UUID saveUserAndGetId(User user);
}
