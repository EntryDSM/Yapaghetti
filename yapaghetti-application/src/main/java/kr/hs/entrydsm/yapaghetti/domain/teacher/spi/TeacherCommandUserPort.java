package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

import java.util.UUID;

public interface TeacherCommandUserPort {
    User saveUserAndGetUser(User user);

    void saveUser(User user);
}
