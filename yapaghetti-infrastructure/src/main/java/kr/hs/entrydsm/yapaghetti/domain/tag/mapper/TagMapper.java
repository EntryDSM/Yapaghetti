package kr.hs.entrydsm.yapaghetti.domain.tag.mapper;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {

    public Tag entityToDomain(TagEntity tagEntity) {
        return Tag.builder()
                .id(tagEntity.getId())
                .name(tagEntity.getName())
                .type(tagEntity.getType())
                .build();
    }

    public TagEntity domainToEntity(Tag tag) {
        return TagEntity.builder()
                .name(tag.getName())
                .type(tag.getType())
                .build();
    }

}
