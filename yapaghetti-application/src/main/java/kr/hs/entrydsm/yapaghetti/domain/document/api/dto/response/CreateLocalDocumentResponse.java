package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateLocalDocumentResponse {
    private final UUID documentId;
}
