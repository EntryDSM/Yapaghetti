package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeLimit;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeOverLimitException;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.AuthSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodeLimitPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GenerateRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.QueryAuthCodeLimitPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class SendEmailAuthCodeUseCaseTest {

	@Mock
	AuthSecurityPort authSecurityPort;

	@Mock
	AuthQueryUserPort authQueryUserPort;

	@Mock
	GenerateRandomStringPort generateRandomStringPort;

	@Mock
	SendMailPort sendMailPort;

	@Mock
	CommandAuthCodePort commandAuthCodePort;

	@Mock
	QueryAuthCodeLimitPort queryAuthCodeLimitPort;

	@Mock
	CommandAuthCodeLimitPort commandAuthCodeLimitPort;

	@InjectMocks
	SendEmailAuthCodeUseCase sendEmailAuthCodeUseCase;

	@Test
	void AuthCodeLimit존재() {
		UUID uuid = UUID.randomUUID();
		String value = "value";
		String authCode = "authCode";

		given(authSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(authQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.email(value)
					.build()
			);
		given(generateRandomStringPort.getAuthCode())
			.willReturn(authCode);
		given(commandAuthCodePort.existsAuthCodeById(value))
			.willReturn(true);
		given(queryAuthCodeLimitPort.queryAuthCodeLimitById(value))
			.willReturn(
				AuthCodeLimit.builder()
					.count(1)
					.build()
			);

		sendEmailAuthCodeUseCase.execute();
	}

	@Test
	void AuthCode미존재() {
		UUID uuid = UUID.randomUUID();
		String value = "value";
		String authCode = "authCode";

		given(authSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(authQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.email(value)
					.build()
			);
		given(generateRandomStringPort.getAuthCode())
			.willReturn(authCode);
		given(commandAuthCodePort.existsAuthCodeById(value))
			.willReturn(false);

		sendEmailAuthCodeUseCase.execute();
	}

	@Test
	void 요청횟수초과() {
		UUID uuid = UUID.randomUUID();
		String value = "value";
		String authCode = "authCode";

		given(authSecurityPort.getCurrentUserId())
			.willReturn(uuid);
		given(authQueryUserPort.queryUserById(uuid))
			.willReturn(
				User.builder()
					.email(value)
					.build()
			);
		given(generateRandomStringPort.getAuthCode())
			.willReturn(authCode);
		given(commandAuthCodePort.existsAuthCodeById(value))
			.willReturn(true);
		given(queryAuthCodeLimitPort.queryAuthCodeLimitById(value))
			.willReturn(
				AuthCodeLimit.builder()
					.count(100)
					.build()
			);

		assertThrows(AuthCodeOverLimitException.class, () -> sendEmailAuthCodeUseCase.execute());
	}
}
