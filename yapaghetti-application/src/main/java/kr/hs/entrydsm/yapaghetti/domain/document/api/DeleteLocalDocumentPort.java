package kr.hs.entrydsm.yapaghetti.domain.document.api;

import java.util.UUID;

public interface DeleteLocalDocumentPort {
    void execute(UUID documentId);
}
