package kr.hs.entrydsm.yapaghetti.domain.user.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

public interface CommandUserPort {
    void saveUser(User user);
}
