package kr.hs.entrydsm.yapaghetti.domain.document.persistence;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.exception.DocumentNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.document.mapper.DocumentMapper;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class DocumentPersistenceAdapter implements CommandDocumentPort, QueryDocumentPort {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    @Override
    public void saveDocument(Document document) {
        documentRepository.save(documentMapper.domainToEntity(document));
    }

    @Override
    public Document queryDocumentById(UUID id) {
        return documentMapper.entityToDomain(
                queryDocumentEntityById(id)
        );
    }

    @Override
    public Document queryPublicDocumentByUserId(UUID userId) {
        return documentMapper.entityToDomain(
                documentRepository.findByUserIdAndType(userId, DocumentType.PUBLIC)
                        .orElseThrow(() -> DocumentNotFoundException.EXCEPTION)
        );
    }

    @Override
    public Document queryStayDocumentByUserId(UUID userId) {
        return documentMapper.entityToDomain(
                documentRepository.findByUserIdAndType(userId, DocumentType.STAY)
                        .orElseThrow(() -> DocumentNotFoundException.EXCEPTION)
        );
    }

    public DocumentEntity queryDocumentEntityById(UUID documentId) {
        return documentRepository.findById(documentId)
                .orElseThrow(() -> DocumentNotFoundException.EXCEPTION);
    }
}
