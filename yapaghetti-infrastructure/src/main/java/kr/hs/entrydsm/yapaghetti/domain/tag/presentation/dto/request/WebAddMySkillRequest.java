package kr.hs.entrydsm.yapaghetti.domain.tag.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebAddMySkillRequest {

    @NotNull
    private List<UUID> tagList;

}
