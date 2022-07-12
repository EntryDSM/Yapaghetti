package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeNotVerifiedException;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.UpdateType;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SetPhoneNumberUseCaseTest {

	@Mock
	StudentQueryAuthCodePort studentQueryAuthCodePort;

	@Mock
	StudentQueryUserPort studentQueryUserPort;

	@Mock
	StudentSecurityPort studentSecurityPort;

	@Mock
	StudentCommandUserPort studentCommandUserPort;

	@InjectMocks
	UpdateMyInfoUseCase setPhoneNumberUseCase;

	static UpdateType type = UpdateType.PHONE;

	@Test
	void 번호_설정() {
		String phoneNumber = "01012345678";
		UUID uuid = UUID.randomUUID();

		given(studentQueryAuthCodePort.queryAuthCodeById(phoneNumber))
			.willReturn(
				AuthCode.builder()
					.isVerify(true)
					.build()
			);
		given(studentSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(studentQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.phoneNumber(phoneNumber)
					.build()
			);

		setPhoneNumberUseCase.execute(phoneNumber, type);
	}

	@Test
	void 인증_미완료() {
		String phoneNumber = "01012345678";

		given(studentQueryAuthCodePort.queryAuthCodeById(phoneNumber))
			.willReturn(
				AuthCode.builder()
					.isVerify(false)
					.build()
			);

		assertThrows(AuthCodeNotVerifiedException.class, () -> setPhoneNumberUseCase.execute(phoneNumber, type));
	}
}
