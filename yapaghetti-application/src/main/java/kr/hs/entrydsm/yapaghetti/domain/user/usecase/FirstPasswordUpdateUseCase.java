package kr.hs.entrydsm.yapaghetti.domain.user.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.user.api.FirstPasswordUpdatePort;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainFirstPasswordUpdateRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserInvalidPasswordException;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.CommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class FirstPasswordUpdateUseCase implements FirstPasswordUpdatePort {

    private final QueryUserPort queryUserPort;
    private final CommandUserPort commandUserPort;
    private final UserSecurityPort userSecurityPort;

    @Override
    public void firstPasswordUpdate(DomainFirstPasswordUpdateRequest request) {
        User user = queryUserPort.queryUserById(userSecurityPort.getCurrentUserId());

        if (!userSecurityPort.matches(request.getPassword(), user.getPassword())) {
            throw UserInvalidPasswordException.EXCEPTION;
        }

        commandUserPort.saveUser(
                user.setUserPasswordAndVisitedTrue(
                        userSecurityPort.encodePassword(request.getNewPassword())
                )
        );
    }
}
