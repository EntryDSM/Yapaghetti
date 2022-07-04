package kr.hs.entrydsm.yapaghetti.domain.document.persistence;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.exception.DocumentNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.document.mapper.DocumentMapper;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.QueryDocumentPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
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

    @Transactional
    @Override
    public void updateDocument(Document document) {
        documentRepository.findById(document.getId())
                .orElseThrow(() -> DocumentNotFoundException.EXCEPTION)
                .changeDocument(document.getPreviewImagePath(), document.getContent());
    }

    @Override
    public Document queryDocumentById(UUID id) {
        return documentMapper.entityToDomain(
                documentRepository.findById(id)
                        .orElseThrow(() -> DocumentNotFoundException.EXCEPTION)
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
    public Document queryDocumentByIdAndUserIdAndType(UUID documentId, UUID userId, DocumentType type) {
        return documentMapper.entityToDomain(
                documentRepository.findByIdAndUserIdAndType(documentId, userId, type)
                        .orElseThrow(() -> DocumentNotFoundException.EXCEPTION)
        );
    }
}
