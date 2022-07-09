package kr.hs.entrydsm.yapaghetti.domain.document.persistence;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.exception.DocumentNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.document.mapper.DocumentMapper;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.DocumentPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Adapter
public class DocumentPersistenceAdapter implements DocumentPort {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    @Override
    public void saveDocument(Document document) {
        documentRepository.save(documentMapper.domainToEntity(document));
    }

    @Override
    public void deleteDocument(Document document) {
        documentRepository.delete(documentMapper.domainToEntity(document));
    }

    @Override
    public Document queryDocumentById(UUID id) {
        return documentMapper.entityToDomain(
                getDocumentById(id)
        );
    }

    @Override
    public Document queryDocumentByIdAndType(UUID documentId, DocumentType type) {
        return documentMapper.entityToDomain(
                documentRepository.findByIdAndType(documentId, type)
                        .orElseThrow(() -> DocumentNotFoundException.EXCEPTION)
        );
    }

    @Override
    public Document queryDocumentByUserIdAndType(UUID userId, DocumentType type) {
        return documentMapper.entityToDomain(
                documentRepository.findByUserEntityIdAndType(userId, type)
                        .orElseThrow(() -> DocumentNotFoundException.EXCEPTION)
        );
    }

    @Override
    public List<Document> queryDocumentAllByUserIdAndType(UUID userId, DocumentType type) {
        return documentRepository.findAllByUserEntityIdAndType(userId, type).stream()
                .map(documentMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Document queryDocumentByIdAndUserIdAndType(UUID documentId, UUID userId, DocumentType type) {
        return documentMapper.entityToDomain(
                documentRepository.findByIdAndUserEntityIdAndType(documentId, userId, type)
                        .orElseThrow(() -> DocumentNotFoundException.EXCEPTION)
        );
    }

    private DocumentEntity getDocumentById(UUID id) {
        return documentRepository.findById(id)
                .orElseThrow(() -> DocumentNotFoundException.EXCEPTION);
    }
}
