package kr.hs.entrydsm.yapaghetti.domain.tag.persistence;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<TagEntity, UUID> {
}
