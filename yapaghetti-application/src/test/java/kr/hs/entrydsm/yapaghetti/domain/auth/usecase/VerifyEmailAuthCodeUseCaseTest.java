package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import java.time.LocalDateTime;
import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyTimeOutException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyVerifiedException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.InvalidAuthCodeException;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.QueryAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VerifyEmailAuthCodeUseCaseTest {

	@Mock
	AuthSecurityPort authSecurityPort;

	@Mock
	AuthQueryUserPort authQueryUserPort;

	@Mock
	QueryAuthCodePort queryAuthCodePort;

	@Mock
	CommandAuthCodePort commandAuthCodePort;

	@InjectMocks
	VerifyEmailAuthCodeUseCase verifyEmailAuthCodeUseCase;

	@Test
	void 인증확인() {
		UUID uuid = UUID.randomUUID();
		String email = "email";
		String authCode = "test";

		given(authSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(authQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.email(email)
					.build()
			);
		given(queryAuthCodePort.queryAuthCodeById(email))
			.willReturn(
				AuthCode.builder()
					.isVerify(false)
					.authTime(LocalDateTime.now().plusSeconds(1))
					.authCode(authCode)
					.build()
			);

		verifyEmailAuthCodeUseCase.execute(authCode);
	}

	@Test
	void 이미_인증됨() {
		UUID uuid = UUID.randomUUID();
		String email = "email";
		String authCode = "test";

		given(authSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(authQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.email(email)
					.build()
			);
		given(queryAuthCodePort.queryAuthCodeById(email))
			.willReturn(
				AuthCode.builder()
					.isVerify(true)
					.authTime(LocalDateTime.now().plusSeconds(1))
					.authCode(authCode)
					.build()
			);

		assertThrows(AuthCodeAlreadyVerifiedException.class, () -> verifyEmailAuthCodeUseCase.execute(authCode));
	}

	@Test
	void 시간초과() {
		UUID uuid = UUID.randomUUID();
		String email = "email";
		String authCode = "test";

		given(authSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(authQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.email(email)
					.build()
			);
		given(queryAuthCodePort.queryAuthCodeById(email))
			.willReturn(
				AuthCode.builder()
					.isVerify(false)
					.authTime(LocalDateTime.now().minusSeconds(1))
					.authCode(authCode)
					.build()
			);

		assertThrows(AuthCodeAlreadyTimeOutException.class, () -> verifyEmailAuthCodeUseCase.execute(authCode));
	}

	@Test
	void 틀린_인증코드() {
		UUID uuid = UUID.randomUUID();
		String email = "email";
		String authCode = "test";
		String invalidAuthCode = "tset";

		given(authSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(authQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.email(email)
					.build()
			);
		given(queryAuthCodePort.queryAuthCodeById(email))
			.willReturn(
				AuthCode.builder()
					.isVerify(false)
					.authTime(LocalDateTime.now().plusSeconds(1))
					.authCode(authCode)
					.build()
			);

		assertThrows(InvalidAuthCodeException.class, () -> verifyEmailAuthCodeUseCase.execute(invalidAuthCode));
	}
}
