package kr.hs.entrydsm.yapaghetti.infrastructure.sms;

import java.util.HashMap;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendSmsPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import kr.hs.entrydsm.yapaghetti.global.property.CoolSmsProperties;
import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@RequiredArgsConstructor
@Adapter
public class CoolSmsAdapter implements SendSmsPort {

	private final CoolSmsProperties coolSmsProperties;

	@Override
	public void sendAuthCode(String phoneNumber, String authCode) {
		Message message = new Message(coolSmsProperties.getKey(), coolSmsProperties.getSecret());

		HashMap<String, String> params = new HashMap<>();
		params.put("to", phoneNumber);
		params.put("from", coolSmsProperties.getPhoneNumber());
		params.put("type", "SMS");
		params.put("text", getBody(authCode));
		params.put("app_version", "app 1.0");

		try {
			message.send(params);
		} catch (CoolsmsException e) {
			e.getStackTrace();
		}

	}

	private String getBody(String authCode) {
		return "인증번호 " + authCode + "를 입력하세요.";
	}
}
