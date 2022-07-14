package kr.hs.entrydsm.yapaghetti.domain.auth.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyTimeOutException;
import kr.hs.entrydsm.yapaghetti.domain.auth.exception.AuthCodeAlreadyVerifiedException;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.CommandAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GenerateRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GetAuthPropertiesPort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.QueryAuthCodePort;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendSmsPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SendPhoneNumberAuthCodeUseCaseTest {

	@Mock
	QueryAuthCodePort queryAuthCodePort;

	@Mock
	CommandAuthCodePort commandAuthCodePort;

	@Mock
	GetAuthPropertiesPort getAuthPropertiesPort;

	@Mock
	GenerateRandomStringPort generateRandomStringPort;

	@Mock
	SendSmsPort sendSmsPort;

	@InjectMocks
	SendPhoneNumberAuthCodeUseCase sendPhoneNumberAuthCodeUseCase;

	@Test
	void 인증번호_존재() {
		String authCode = "test";
		Long authTime = 1L;
		Long limitTime = 2L;
		String phoneNumber = "01012345678";

		given(generateRandomStringPort.getAuthCode())
			.willReturn(authCode);
		given(getAuthPropertiesPort.getAuthTime())
			.willReturn(authTime);
		given(commandAuthCodePort.existsAuthCodeById(phoneNumber))
			.willReturn(true);
		given(queryAuthCodePort.queryAuthCodeById(phoneNumber))
			.willReturn(
				AuthCode.builder()
					.isVerify(false)
					.timeToLive(authTime)
					.build()
			);
		given(getAuthPropertiesPort.getLimitTime())
			.willReturn(limitTime);

		sendPhoneNumberAuthCodeUseCase.execute(phoneNumber);
	}

	@Test
	void 이미_인증됨() {
		String authCode = "test";
		Long authTime = 1L;
		String phoneNumber = "01012345678";

		given(generateRandomStringPort.getAuthCode())
			.willReturn(authCode);
		given(getAuthPropertiesPort.getAuthTime())
			.willReturn(authTime);
		given(commandAuthCodePort.existsAuthCodeById(phoneNumber))
			.willReturn(true);
		given(queryAuthCodePort.queryAuthCodeById(phoneNumber))
			.willReturn(
				AuthCode.builder()
					.isVerify(true)
					.timeToLive(authTime)
					.build()
			);

		assertThrows(AuthCodeAlreadyVerifiedException.class, () -> sendPhoneNumberAuthCodeUseCase.execute(phoneNumber));
	}

	@Test
	void 인증시간_만료() {
		String authCode = "test";
		Long authTime = 2L;
		Long limitTime = 1L;
		String phoneNumber = "01012345678";

		given(generateRandomStringPort.getAuthCode())
			.willReturn(authCode);
		given(getAuthPropertiesPort.getAuthTime())
			.willReturn(authTime);
		given(commandAuthCodePort.existsAuthCodeById(phoneNumber))
			.willReturn(true);
		given(queryAuthCodePort.queryAuthCodeById(phoneNumber))
			.willReturn(
				AuthCode.builder()
					.isVerify(false)
					.timeToLive(authTime)
					.build()
			);
		given(getAuthPropertiesPort.getLimitTime())
			.willReturn(limitTime);

		assertThrows(AuthCodeAlreadyTimeOutException.class, () -> sendPhoneNumberAuthCodeUseCase.execute(phoneNumber));
	}

	@Test
	void 인증번호_미존재() {
		String authCode = "test";
		Long authTime = 1L;
		String phoneNumber = "01012345678";

		given(generateRandomStringPort.getAuthCode())
			.willReturn(authCode);
		given(getAuthPropertiesPort.getAuthTime())
			.willReturn(authTime);
		given(commandAuthCodePort.existsAuthCodeById(phoneNumber))
			.willReturn(false);

		sendPhoneNumberAuthCodeUseCase.execute(phoneNumber);
	}
}
