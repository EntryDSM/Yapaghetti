package kr.hs.entrydsm.yapaghetti.domain.user.presentation;

import kr.hs.entrydsm.yapaghetti.domain.user.api.SignInPort;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainSignInRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.response.SignInResponse;
import kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request.WebSignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserWebAdapter {

    private final SignInPort signInPort;

    @PostMapping("/auth")
    public SignInResponse signIn(@RequestBody @Valid WebSignInRequest request) {
        return signInPort.signIn(
                DomainSignInRequest.builder()
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .userType(request.getUserType())
                        .build()
        );
    }

}
