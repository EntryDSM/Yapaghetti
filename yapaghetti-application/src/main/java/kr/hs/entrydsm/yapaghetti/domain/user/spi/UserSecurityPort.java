package kr.hs.entrydsm.yapaghetti.domain.user.spi;

public interface UserSecurityPort {
    boolean matches(String rawPassword, String encodedPassword);
}
