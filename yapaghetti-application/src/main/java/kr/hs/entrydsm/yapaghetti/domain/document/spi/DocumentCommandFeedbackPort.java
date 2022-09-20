package kr.hs.entrydsm.yapaghetti.domain.document.spi;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;

import java.util.UUID;

public interface DocumentCommandFeedbackPort {
    void deleteAllByDocumentId(UUID uuid);
}
