package kr.hs.entrydsm.yapaghetti.domain.tag.persistence;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.TagType;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TagRepository extends CrudRepository<TagEntity, UUID> {
    boolean existsByName(String name);
    List<TagEntity> findAllByNameContainingAndType(String name, TagType type);

    Optional<TagEntity> findByIdAndType(UUID id, TagType type);
}
