package kr.hs.entrydsm.yapaghetti.domain.user.presentation;

import kr.hs.entrydsm.yapaghetti.domain.user.api.FirstPasswordUpdatePort;
import kr.hs.entrydsm.yapaghetti.domain.user.api.SignInPort;
import kr.hs.entrydsm.yapaghetti.domain.user.api.TokenRefreshPort;
import kr.hs.entrydsm.yapaghetti.domain.user.api.UpdateUserInformationPort;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainFirstPasswordUpdateRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainSignInRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainUpdateUserInformationRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.response.SignInResponse;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.response.TokenRefreshResponse;
import kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request.WebFirstPasswordUpdateRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request.WebSignInRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request.WebUpdateUserInformationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserWebAdapter {

    private final SignInPort signInPort;
    private final FirstPasswordUpdatePort firstPasswordUpdatePort;
    private final UpdateUserInformationPort userInformationPort;
    private final TokenRefreshPort tokenRefreshPort;

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

    @PutMapping("/auth")
    public TokenRefreshResponse tokenRefresh(@RequestHeader("REFRESH-TOKEN") String token) {
        return tokenRefreshPort.execute(token);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/first-password")
    public void firstPassword(@RequestBody @Valid WebFirstPasswordUpdateRequest request) {
        firstPasswordUpdatePort.firstPasswordUpdate(
                DomainFirstPasswordUpdateRequest.builder()
                        .password(request.getPassword())
                        .newPassword(request.getNewPassword())
                        .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/information")
    public void updateUserInformation(@RequestBody @Valid WebUpdateUserInformationRequest request) {
        userInformationPort.execute(
                DomainUpdateUserInformationRequest.builder()
                        .location(request.getLocation())
                        .name(request.getName())
                        .phoneNumber(request.getPhoneNumber())
                        .profileImagePath(request.getProfileImagePath())
                        .build()
        );
    }


}
