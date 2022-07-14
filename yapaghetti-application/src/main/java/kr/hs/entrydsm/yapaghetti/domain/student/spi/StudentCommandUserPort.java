package kr.hs.entrydsm.yapaghetti.domain.student.spi;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

public interface StudentCommandUserPort {
	void saveUser(User user);
}
