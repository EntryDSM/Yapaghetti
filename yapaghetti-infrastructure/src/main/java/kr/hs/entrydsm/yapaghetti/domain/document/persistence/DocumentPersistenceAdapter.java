package kr.hs.entrydsm.yapaghetti.domain.document.persistence;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.Document;
import kr.hs.entrydsm.yapaghetti.domain.document.mapper.DocumentMapper;
import kr.hs.entrydsm.yapaghetti.domain.document.spi.CommandDocumentPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DocumentPersistenceAdapter implements CommandDocumentPort {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    @Override
    public void saveDocument(Document document) {
        documentRepository.save(documentMapper.domainToEntity(document));
    }
}
