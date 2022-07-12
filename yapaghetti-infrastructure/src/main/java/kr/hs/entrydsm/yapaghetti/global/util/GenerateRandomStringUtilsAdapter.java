package kr.hs.entrydsm.yapaghetti.global.util;

import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GenerateRandomStringPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import org.apache.commons.lang3.RandomStringUtils;

@Adapter
public class GenerateRandomStringUtilsAdapter implements GenerateRandomStringPort {

	@Override
	public String getAuthCode() {
		return RandomStringUtils.randomNumeric(5);
	}
}
