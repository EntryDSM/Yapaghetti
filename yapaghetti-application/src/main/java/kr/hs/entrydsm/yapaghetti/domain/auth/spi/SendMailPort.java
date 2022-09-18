package kr.hs.entrydsm.yapaghetti.domain.auth.spi;

import java.util.List;
import kr.hs.entrydsm.yapaghetti.domain.auth.enums.EmailType;

public interface SendMailPort {
    void sendAuthCode(String email, List<String> values, EmailType emailType);
}
