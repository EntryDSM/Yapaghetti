package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeNotVerifiedException;
import kr.hs.entrydsm.yapaghetti.domain.student.api.SetPhoneNumberPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SetPhoneNumberUseCase implements SetPhoneNumberPort {

	private final StudentQueryAuthCodePort studentQueryAuthCodePort;
	private final StudentQueryUserPort studentQueryUserPort;
	private final StudentSecurityPort studentSecurityPort;
	private final StudentCommandUserPort studentCommandUserPort;

	@Override
	public void execute(String phoneNumber) {
		AuthCode authCode = studentQueryAuthCodePort.queryAuthCodeById(phoneNumber);

		if (!authCode.isVerify()) {
			throw AuthCodeNotVerifiedException.EXCEPTION;
		}

		User user = studentQueryUserPort.queryUserById(
			studentSecurityPort.getCurrentUserId()
		);

		studentCommandUserPort.saveUser(user.SetPhoneNumber(phoneNumber));
	}
}
