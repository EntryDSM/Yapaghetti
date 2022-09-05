package kr.hs.entrydsm.yapaghetti.domain.tag.persistence;

import java.util.Optional;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.MySkillPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.student.persistence.StudentPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.TagType;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.AlreadyExistsTagException;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.UnableDeleteTagException;
import kr.hs.entrydsm.yapaghetti.domain.tag.mapper.TagMapper;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
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

    private final MySkillPersistenceAdapter mySkillPersistenceAdapter;
    private final StudentPersistenceAdapter studentPersistenceAdapter;

    private final TagMapper tagMapper;

    public Optional<TagEntity> findByTagId(UUID tagId) {
        return tagRepository.findById(tagId);
    }

    @Override
    public void saveTag(Tag tag) {
        tagRepository.save(
                tagMapper.domainToEntity(tag)
        );
    }

    @Override
    public void existsById(UUID tagId) {
        if (!tagRepository.existsById(tagId)) {
            throw TagNotFoundException.EXCEPTION;
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
        queryTagById(tagId);

        if (mySkillPersistenceAdapter.existsByTagId(tagId) || studentPersistenceAdapter.existsByTagId(tagId)) {
            throw UnableDeleteTagException.EXCEPTION;
        }

        tagRepository.deleteById(tagId);
    }

    @Override
    public void existsByName(String name) {
        if (tagRepository.existsByName(name)) {
            throw AlreadyExistsTagException.EXCEPTION;
        }
    }

}
