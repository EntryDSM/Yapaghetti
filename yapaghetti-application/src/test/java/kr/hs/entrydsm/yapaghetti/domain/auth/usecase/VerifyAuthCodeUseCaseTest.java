package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import java.time.LocalDateTime;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyTimeOutException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyVerifiedException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.InvalidAuthCodeException;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.QueryAuthCodePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VerifyAuthCodeUseCaseTest {

	@Mock
	QueryAuthCodePort queryAuthCodePort;

	@Mock
	CommandAuthCodePort commandAuthCodePort;

	@InjectMocks
	VerifyAuthCodeUseCase verifyAuthCodeUseCase;

	@Test
	void 인증확인() {
		String value = "test";
		String authCode = "test";

		given(queryAuthCodePort.queryAuthCodeById(value))
			.willReturn(
				AuthCode.builder()
					.isVerify(false)
					.authTime(LocalDateTime.now().plusSeconds(1))
					.authCode(authCode)
					.build()
			);

		verifyAuthCodeUseCase.execute(authCode, value);
	}

	@Test
	void 이미_인증됨() {
		String value = "value";
		String authCode = "test";

		given(queryAuthCodePort.queryAuthCodeById(value))
			.willReturn(
				AuthCode.builder()
					.isVerify(true)
					.authTime(LocalDateTime.now().plusSeconds(1))
					.authCode(authCode)
					.build()
			);

		assertThrows(AuthCodeAlreadyVerifiedException.class, () -> verifyAuthCodeUseCase.execute(authCode, value));
	}

	@Test
	void 시간초과() {
		String value = "value";
		String authCode = "test";

		given(queryAuthCodePort.queryAuthCodeById(value))
			.willReturn(
				AuthCode.builder()
					.isVerify(false)
					.authTime(LocalDateTime.now().minusSeconds(1))
					.authCode(authCode)
					.build()
			);

		assertThrows(AuthCodeAlreadyTimeOutException.class, () -> verifyAuthCodeUseCase.execute(authCode, value));
	}

	@Test
	void 틀린_인증코드() {
		String value = "value";
		String authCode = "test";
		String invalidAuthCode = "tset";

		given(queryAuthCodePort.queryAuthCodeById(value))
			.willReturn(
				AuthCode.builder()
					.isVerify(false)
					.authTime(LocalDateTime.now().plusSeconds(1))
					.authCode(authCode)
					.build()
			);

		assertThrows(InvalidAuthCodeException.class, () -> verifyAuthCodeUseCase.execute(invalidAuthCode, value));
	}
}
