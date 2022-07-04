package kr.hs.entrydsm.yapaghetti.domain.my_skill.mapper;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.MySkillEntity;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.MySkillEntityId;
import org.springframework.stereotype.Component;

@Component
public class MySkillMapper {

    public MySkillEntity domainToEntity(MySkill mySkill) {
        return MySkillEntity.builder()
                .id(
                        new MySkillEntityId(
                               mySkill.getUserId(),
                               mySkill.getTagId()
                        )
                )
                .build();
    }

}
