package kr.hs.entrydsm.yapaghetti.domain.tag.persistence;

import java.util.Optional;
import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class TagPersistenceAdapter {

    private final TagRepository tagRepository;

    public Optional<TagEntity> findTagById(UUID tagId) {
        return tagRepository.findById(tagId);
    }
}
