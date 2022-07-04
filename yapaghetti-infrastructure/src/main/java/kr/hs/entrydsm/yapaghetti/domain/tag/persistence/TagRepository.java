package kr.hs.entrydsm.yapaghetti.domain.tag.persistence;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.TagType;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TagRepository extends CrudRepository<TagEntity, UUID> {
    boolean existsByName(String name);
    List<TagEntity> findAllByNameContainingAndType(String name, TagType type);
}
