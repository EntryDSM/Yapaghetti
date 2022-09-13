package kr.hs.entrydsm.yapaghetti.domain.auth.api;

import kr.hs.entrydsm.yapaghetti.domain.auth.api.dto.response.SendEmailAuthCodeResponse;

public interface SendEmailAuthCodePort {
    SendEmailAuthCodeResponse execute();
}
