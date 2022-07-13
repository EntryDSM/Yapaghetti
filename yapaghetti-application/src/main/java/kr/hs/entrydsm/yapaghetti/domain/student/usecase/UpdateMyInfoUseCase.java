package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeNotVerifiedException;
import kr.hs.entrydsm.yapaghetti.domain.student.api.UpdateMyInfoPort;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.UpdateType;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UpdateMyInfoUseCase implements UpdateMyInfoPort {

	private final StudentQueryAuthCodePort studentQueryAuthCodePort;
	private final StudentQueryUserPort studentQueryUserPort;
	private final StudentSecurityPort studentSecurityPort;
	private final StudentCommandUserPort studentCommandUserPort;

	@Override
	public void execute(String value, UpdateType type) {
		AuthCode authCode = studentQueryAuthCodePort.queryAuthCodeById(value);

		if (!authCode.isVerify()) {
			throw AuthCodeNotVerifiedException.EXCEPTION;
		}

		User user = studentQueryUserPort.queryUserById(
			studentSecurityPort.getCurrentUserId()
		);

		user = switch (type) {
			case PHONE -> user.SetPhoneNumber(value);
			case PASSWORD -> user.SetPassword(value);
		};

		studentCommandUserPort.saveUser(user);
	}
}
