package kr.hs.entrydsm.yapaghetti.domain.tag.persistence;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.tag.mapper.TagMapper;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.CommandTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TagPersistenceAdapter implements CommandTagPort, QueryTagPort {

    private final TagRepository tagRepository;

    private final TagMapper tagMapper;

    @Override
    public void saveNewTag(Tag tag) {
        tagRepository.save(
                tagMapper.domainToEntity(tag)
        );
    }

    @Override
    public boolean existByName(String name) {
        return tagRepository.existsByName(name);
    }
}
