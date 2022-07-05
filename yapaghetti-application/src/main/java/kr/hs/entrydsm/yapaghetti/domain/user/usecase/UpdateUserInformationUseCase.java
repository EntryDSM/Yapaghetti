package kr.hs.entrydsm.yapaghetti.domain.user.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.user.api.UpdateUserInformationPort;
import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainUpdateUserInformationRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.CommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UpdateUserInformationUseCase implements UpdateUserInformationPort {

    private final UserSecurityPort userSecurityPort;
    private final QueryUserPort queryUserPort;
    private final CommandUserPort commandUserPort;

    @Override
    public void execute(DomainUpdateUserInformationRequest request) {
        User user = queryUserPort.queryUserById(userSecurityPort.getCurrentUserId());

        commandUserPort.saveUser(
                user.setInformation(
                        request.getLocation(),
                        request.getName(),
                        request.getPhoneNumber(),
                        request.getProfileImagePath()
                )
        );
    }

}
