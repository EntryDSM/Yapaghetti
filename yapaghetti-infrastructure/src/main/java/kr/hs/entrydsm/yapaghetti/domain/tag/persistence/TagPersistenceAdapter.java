package kr.hs.entrydsm.yapaghetti.domain.tag.persistence;

import java.util.Optional;
import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TagPersistenceAdapter {

    private final TagRepository tagRepository;

    public Optional<TagEntity> findTagById(UUID tagId) {
        return tagRepository.findById(tagId);
    }
}
