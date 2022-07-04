package kr.hs.entrydsm.yapaghetti.domain.tag.presentation;

import kr.hs.entrydsm.yapaghetti.domain.tag.api.AddMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.AddTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.DeleteTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainAddMySkillRequest;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainAddTagRequest;
import kr.hs.entrydsm.yapaghetti.domain.tag.presentation.dto.request.WebAddMySkillRequest;
import kr.hs.entrydsm.yapaghetti.domain.tag.presentation.dto.request.WebAddTagRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/tags")
@RestController
public class TagWebAdapter {

    private final AddTagPort addTagPort;
    private final DeleteTagPort deleteTagPort;

    private final AddMySkillPort addMySkillPort;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addTag(@RequestBody @Valid WebAddTagRequest request) {
        addTagPort.execute(
                DomainAddTagRequest.builder()
                        .name(request.getName())
                        .isMajor(request.getIsMajor())
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{tag-id}")
    public void deleteTag(@PathVariable("tag-id")UUID tagId) {
        deleteTagPort.execute(tagId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void setMySkill(@RequestBody @Valid WebAddMySkillRequest request) {
        addMySkillPort.execute(new DomainAddMySkillRequest(request.getTagList()));
    }

}
