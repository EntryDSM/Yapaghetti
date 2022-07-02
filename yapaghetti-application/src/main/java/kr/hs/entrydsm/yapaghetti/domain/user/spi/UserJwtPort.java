package kr.hs.entrydsm.yapaghetti.domain.user.spi;

public interface UserJwtPort {
    String generateAccessToken(String email, String role);
}
