package kr.hs.entrydsm.yapaghetti.domain.company.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

public interface CompanyCommandUserPort {
    void saveUser(User user);
}
