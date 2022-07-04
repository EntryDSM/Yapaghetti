package kr.hs.entrydsm.yapaghetti.domain.document.presentation;

import kr.hs.entrydsm.yapaghetti.domain.document.api.CopyPublicDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.CreateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.DeleteLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.DeletePublicDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryProtectedDocumentUrlPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryPublicDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.UpdateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainCreateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryDocumentResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryProtectedDocumentUrlResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.presentation.dto.request.WebLocalDocumentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/documents")
@RestController
public class DocumentWebAdapter {

    private final CreateLocalDocumentPort createLocalDocumentPort;
    private final QueryPublicDocumentPort queryPublicDocumentPort;
    private final CopyPublicDocumentPort copyPublicDocumentPort;
    private final UpdateLocalDocumentPort updateLocalDocumentPort;
    private final QueryProtectedDocumentUrlPort queryProtectedDocumentUrlPort;
    private final DeletePublicDocumentPort deletePublicDocumentPort;
    private final QueryLocalDocumentPort queryLocalDocumentPort;
    private final DeleteLocalDocumentPort deleteLocalDocumentPort;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createLocalDocument(@RequestBody @Valid WebLocalDocumentRequest request) {
        createLocalDocumentPort.execute(
                DomainCreateLocalDocumentRequest.builder()
                        .previewImagePath(request.getPreviewImagePath())
                        .content(request.getContent())
                        .build()
        );
    }

    @GetMapping("/public/{document-id}")
    public QueryDocumentResponse getPublicDocument(@PathVariable("document-id") UUID documentId) {
        return queryPublicDocumentPort.execute(documentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/copy")
    public void copyPublicDocumentToLocal() {
        copyPublicDocumentPort.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{document-id}")
    public void updateLocalDocument(@PathVariable("document-id") UUID documentId,
                                    @RequestBody @Valid WebLocalDocumentRequest request) {

        updateLocalDocumentPort.execute(
                DomainUpdateLocalDocumentRequest.builder()
                        .documentId(documentId)
                        .previewImagePath(request.getPreviewImagePath())
                        .content(request.getContent())
                        .build()
        );
    }

    @GetMapping("/protected-url")
    public QueryProtectedDocumentUrlResponse getProtectedDocumentUrl() {
        return queryProtectedDocumentUrlPort.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/public/{student-id}")
    public void deletePublicDocument(@PathVariable("student-id") UUID userId) {
        deletePublicDocumentPort.execute(userId);
    }

    @GetMapping("/{document-id}")
    public QueryDocumentResponse getLocalDocument(@PathVariable("document-id") @NotBlank UUID documentId) {
        return queryLocalDocumentPort.execute(documentId);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{document-id}")
    public void deleteLocalDocument(@PathVariable("document-id") @NotBlank UUID documentId) {
        deleteLocalDocumentPort.execute(documentId);

    }
}
