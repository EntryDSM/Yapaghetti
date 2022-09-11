package kr.hs.entrydsm.yapaghetti.domain.tag.persistence;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.TagType;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.mapper.TagMapper;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Adapter
public class TagPersistenceAdapter implements TagPort {

    private final TagRepository tagRepository;

    private final TagMapper tagMapper;

    @Override
    public void saveTag(Tag tag) {
        tagRepository.save(
                tagMapper.domainToEntity(tag)
        );
    }

    @Override
    public List<Tag> queryAllTagByNameContainingAndIsMajor(String name, boolean isMajor) {
        TagType type = isMajor ? TagType.MAJOR : TagType.SKILL;

        return tagRepository.findAllByNameContainingAndType(name, type).stream()
                .map(tagMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Tag queryTagById(UUID tagId) {
        return tagMapper.entityToDomain(
                tagRepository.findById(tagId)
                        .orElseThrow(() -> TagNotFoundException.EXCEPTION)
        );
    }

    @Override
    public void deleteTagById(UUID tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public boolean existsTagByName(String name) {
        return tagRepository.existsByName(name);
    }

}
