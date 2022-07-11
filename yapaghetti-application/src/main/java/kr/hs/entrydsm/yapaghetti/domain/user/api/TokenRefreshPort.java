package kr.hs.entrydsm.yapaghetti.domain.user.api;

import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.response.TokenRefreshResponse;

public interface TokenRefreshPort {
    TokenRefreshResponse execute(String token);
}
