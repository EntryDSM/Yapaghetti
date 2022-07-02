package kr.hs.entrydsm.yapaghetti.domain.user.api;

import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainSignInRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.response.SignInResponse;

public interface SignInPort {
    SignInResponse signIn(DomainSignInRequest request);
}
