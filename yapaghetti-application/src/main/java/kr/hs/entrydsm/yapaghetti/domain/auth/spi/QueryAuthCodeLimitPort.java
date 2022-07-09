package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCodeLimit;

public interface QueryAuthCodeLimitPort {
	AuthCodeLimit queryAuthCodeLimitById(String id);
}
