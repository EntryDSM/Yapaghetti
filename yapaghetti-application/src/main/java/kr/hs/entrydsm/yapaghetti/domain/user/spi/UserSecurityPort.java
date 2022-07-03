package kr.hs.entrydsm.yapaghetti.domain.user.spi;

import java.util.UUID;

public interface UserSecurityPort {
    String encodePassword(String password);
    boolean matches(String rawPassword, String encodedPassword);
    UUID getCurrentUserId();
}
