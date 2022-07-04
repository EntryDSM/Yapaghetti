package kr.hs.entrydsm.yapaghetti.domain.tag.persistence;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.tag.mapper.TagMapper;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.CommandTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import java.util.Optional;
import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class TagPersistenceAdapter implements CommandTagPort, QueryTagPort {

    private final TagRepository tagRepository;

    private final TagMapper tagMapper;

    @Override
    public void saveTag(Tag tag) {
        tagRepository.save(
                tagMapper.domainToEntity(tag)
        );
    }

    @Override
    public boolean existByName(String name) {
        return tagRepository.existsByName(name);
    }

    public Optional<TagEntity> findTagById(UUID tagId) {
        return tagRepository.findById(tagId);
    }

}
