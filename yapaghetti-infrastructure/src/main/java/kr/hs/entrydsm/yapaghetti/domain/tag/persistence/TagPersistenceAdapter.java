package kr.hs.entrydsm.yapaghetti.domain.tag.persistence;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.MySkillPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.student.persistence.StudentPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.TagType;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.UnableDeleteTagException;
import kr.hs.entrydsm.yapaghetti.domain.tag.mapper.TagMapper;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.CommandTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class TagPersistenceAdapter implements CommandTagPort, QueryTagPort {

    private final TagRepository tagRepository;

    private final MySkillPersistenceAdapter mySkillPersistenceAdapter;
    private final StudentPersistenceAdapter studentPersistenceAdapter;

    private final TagMapper tagMapper;

    @Override
    public void saveTag(Tag tag) {
        tagRepository.save(
                tagMapper.domainToEntity(tag)
        );
    }

    @Override
    public boolean existsById(UUID tagId) {
        return tagRepository.existsById(tagId);
    }

    @Override
    public List<Tag> findAllByNameLikeAndIsMajor(String name, boolean isMajor) {
        TagType type = isMajor ? TagType.MAJOR : TagType.SKILL;

        return tagRepository.findAllByNameLikeAndType(name, type).stream()
                .map(tagMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTagById(UUID tagId) {
        if (mySkillPersistenceAdapter.existsByTagId(tagId) || studentPersistenceAdapter.existsByTagId(tagId)) {
            throw UnableDeleteTagException.EXCEPTION;
        }

        tagRepository.deleteById(tagId);
    }

    @Override
    public boolean existByName(String name) {
        return tagRepository.existsByName(name);
    }

    public Optional<TagEntity> findTagById(UUID tagId) {
        return tagRepository.findById(tagId);
    }

}
