package kr.hs.entrydsm.yapaghetti.global.util;

import kr.hs.entrydsm.yapaghetti.domain.auth.spi.RandomStringPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import org.apache.commons.lang3.RandomStringUtils;

@Adapter
public class GenerateRandomStringUtilsAdapter implements RandomStringPort {

	@Override
	public String getAuthCode() {
		return RandomStringUtils.randomNumeric(5);
	}

	@Override
	public String getRandomPassword() {
		return RandomStringUtils.randomNumeric(10);
	}
}
