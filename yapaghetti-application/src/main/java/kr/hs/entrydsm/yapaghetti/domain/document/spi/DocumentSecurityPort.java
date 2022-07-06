package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import java.util.UUID;

public interface DocumentSecurityPort {
    UUID getCurrentUserId();
}
