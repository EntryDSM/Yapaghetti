package kr.hs.entrydsm.yapaghetti.domain.my_skill.mapper;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.MySkillEntity;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.MySkillEntityId;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.TagRepository;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.UserRepository;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MySkillMapper {

    private final UserRepository userRepository;
    private final TagRepository tagRepository;

    public MySkillEntity domainToEntity(MySkill mySkill) {
        UserEntity userEntity = userRepository.findById(mySkill.getUserId())
            .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        TagEntity tagEntity = tagRepository.findById(mySkill.getTagId())
            .orElseThrow(() -> TagNotFoundException.EXCEPTION);

        return MySkillEntity.builder()
                .id(
                        new MySkillEntityId(
                               mySkill.getUserId(),
                               mySkill.getTagId()
                        )
                )
                .userEntity(userEntity)
                .tagEntity(tagEntity)
                .build();
    }

    public MySkill entityToDomain(MySkillEntity mySkillEntity) {
        return MySkill.builder()
            .tagId(mySkillEntity.getId().getTagId())
            .userId(mySkillEntity.getId().getUserId())
            .build();
    }

}
