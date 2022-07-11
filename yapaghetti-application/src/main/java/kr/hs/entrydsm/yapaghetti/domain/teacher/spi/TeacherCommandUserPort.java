package kr.hs.entrydsm.yapaghetti.domain.teacher.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

public interface TeacherCommandUserPort {
    void saveUser(User user);
}
