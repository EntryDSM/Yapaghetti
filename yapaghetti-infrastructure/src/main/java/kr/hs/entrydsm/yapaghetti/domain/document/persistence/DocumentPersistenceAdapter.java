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
    public UUID saveDocumentAndGetId(Document document) {
        return documentRepository.save(documentMapper.domainToEntity(document)).getId();
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
    public List<Document> queryDocumentAllByUserIdAndTypeNotIn(UUID userId, List<DocumentType> type) {
        return documentRepository.findAllByUserEntityIdAndTypeNotIn(userId, type).stream()
                .map(documentMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean checkDocumentByUserIdAndType(UUID userId, DocumentType type) {

        // isExist로 나중에 수정하기 TODO

         DocumentEntity documentEntity =  documentRepository.findByUserEntityIdAndType(userId, type)
                 .orElse(null);

         return documentEntity != null;
    }

    @Override
    public Document queryDocumentByIdAndUserIdAndType(UUID documentId, UUID userId, DocumentType type) {
        return documentMapper.entityToDomain(
                documentRepository.findByIdAndUserEntityIdAndType(documentId, userId, type)
                        .orElseThrow(() -> DocumentNotFoundException.EXCEPTION)
        );
    }
}
