package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

import java.util.UUID;

public interface AuthSecurityPort {
	UUID getCurrentUserId();
}
