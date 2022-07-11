package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;

public interface AuthQueryUserPort {
	User queryUserById(UUID id);
}
