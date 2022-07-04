package kr.hs.entrydsm.yapaghetti.domain.document.api;

import java.util.UUID;

public interface DeletePublicDocumentPort {
    void execute(UUID userId);
}
