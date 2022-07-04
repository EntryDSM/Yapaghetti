package kr.hs.entrydsm.yapaghetti.domain.tag.presentation;

import kr.hs.entrydsm.yapaghetti.domain.tag.api.AddTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainAddTagRequest;
import kr.hs.entrydsm.yapaghetti.domain.tag.presentation.dto.request.WebAddTagRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/tags")
@RestController
public class TagWebAdapter {

    private final AddTagPort addTagPort;

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

}
