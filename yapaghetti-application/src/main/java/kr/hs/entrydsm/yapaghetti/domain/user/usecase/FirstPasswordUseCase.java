package kr.hs.entrydsm.yapaghetti.domain.user.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.user.api.FirstPasswordPort;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainFirstPasswordRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserInvalidPasswordException;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.CommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class FirstPasswordUseCase implements FirstPasswordPort {

    private final QueryUserPort queryUserPort;
    private final CommandUserPort commandUserPort;
    private final UserSecurityPort userSecurityPort;

    @Override
    public void firstPassword(DomainFirstPasswordRequest request) {
        User user = queryUserPort.queryUserByPublicId(userSecurityPort.getCurrentUserPublicId());

        if(!userSecurityPort.matches(request.getPassword(), user.getPassword())) {
            throw UserInvalidPasswordException.EXCEPTION;
        }

        commandUserPort.saveUser(
                user.setUserPasswordAndVisitedTrue(
                        userSecurityPort.encodePassword(request.getNewPassword())
                )
        );
    }
}
