package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

import kr.hs.entrydsm.yapaghetti.domain.auth.domain.AuthCode;

public interface QueryAuthCodePort {
    AuthCode queryAuthCodeById(String id);
}
