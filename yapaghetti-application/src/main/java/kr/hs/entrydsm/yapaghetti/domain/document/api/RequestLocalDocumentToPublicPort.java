package kr.hs.entrydsm.yapaghetti.domain.document.api;

import java.util.UUID;

public interface RequestLocalDocumentToPublicPort {
    void execute(UUID documentId);
}
