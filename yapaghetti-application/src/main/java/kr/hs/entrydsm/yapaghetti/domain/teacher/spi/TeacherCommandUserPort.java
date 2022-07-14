package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

import java.util.UUID;

public interface TeacherCommandUserPort {
    UUID saveUserAndUserGetId(User user);
    void saveUser(User user);
}
