package kr.hs.entrydsm.yapaghetti.domain.document.presentation;

import kr.hs.entrydsm.yapaghetti.domain.document.api.ApproveStayDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.CancelStayDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.CopyPublicDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.CreateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.DeleteLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.DeletePublicDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryLocalDocumentListPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryProtectedDocumentUrlPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryPublicDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryStayAndPublicDocumentPreviewPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.QueryStayDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.RequestLocalDocumentToPublicPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.UpdateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.UpdateStayDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainCreateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateStayDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryDocumentResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryLocalDocumentListResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryProtectedDocumentUrlResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryStayAndPublicDocumentPreviewResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.QueryStayDocumentResponse;
import kr.hs.entrydsm.yapaghetti.domain.document.presentation.dto.request.WebCreateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.presentation.dto.request.WebUpdateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.presentation.dto.request.WebUpdateStayDocumentRequest;
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
    private final QueryStayDocumentPort queryStayDocumentPort;
    private final CancelStayDocumentPort cancelStayDocumentPort;
    private final RequestLocalDocumentToPublicPort requestLocalDocumentToPublicPort;
    private final UpdateStayDocumentPort updateStayDocumentPort;
    private final QueryLocalDocumentListPort queryLocalDocumentListPort;
    private final QueryStayAndPublicDocumentPreviewPort queryStayAndPublicDocumentPreviewPort;
    private final ApproveStayDocumentPort approveStayDocumentPort;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createLocalDocument(@RequestBody @Valid WebCreateLocalDocumentRequest request) {
        createLocalDocumentPort.execute(
                new DomainCreateLocalDocumentRequest(request.getPreviewImagePath(), request.getContent())
        );
    }

    @GetMapping("/public/{document-id}")
    public QueryDocumentResponse getPublicDocument(@PathVariable("document-id") @NotBlank UUID documentId) {
        return queryPublicDocumentPort.execute(documentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/copy")
    public void copyPublicDocumentToLocal() {
        copyPublicDocumentPort.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{document-id}")
    public void updateLocalDocument(@PathVariable("document-id") @NotBlank UUID documentId,
                                    @RequestBody @Valid WebUpdateLocalDocumentRequest request) {

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
    public void deletePublicDocument(@PathVariable("student-id") @NotBlank UUID userId) {
        deletePublicDocumentPort.execute(userId);
    }

    @GetMapping("/{document-id}")
    public QueryDocumentResponse getLocalDocument(@PathVariable("document-id") @NotBlank UUID documentId) {
        return queryLocalDocumentPort.execute(documentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{document-id}")
    public void deleteLocalDocument(@PathVariable("document-id") @NotBlank UUID documentId) {
        deleteLocalDocumentPort.execute(documentId);
    }

    @GetMapping("/stay/{document-id}")
    public QueryStayDocumentResponse getStayDocument(@PathVariable("document-id") @NotBlank UUID documentId) {
        return queryStayDocumentPort.execute(documentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/cancel/{document-id}")
    public void cancelStayDocument(@PathVariable("document-id") @NotBlank UUID documentId) {
        cancelStayDocumentPort.execute(documentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{document-id}")
    public void requestLocalDocumentToPublic(@PathVariable("document-id") @NotBlank UUID documentId) {
        requestLocalDocumentToPublicPort.execute(documentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/stay")
    public void updateStayDocument(@RequestBody @Valid WebUpdateStayDocumentRequest request) {
        updateStayDocumentPort.execute(
                new DomainUpdateStayDocumentRequest(request.getPreviewImagePath(), request.getContent())
        );
    }
    
    @GetMapping("/list")
    public QueryLocalDocumentListResponse getLocalDocumentList() {
        return queryLocalDocumentListPort.execute();
    }

    @GetMapping("/preview/{student-id}")
    public QueryStayAndPublicDocumentPreviewResponse getStayAndPublicDocumentList(
            @PathVariable("student-id") @NotBlank UUID studentId
    ) {
        return queryStayAndPublicDocumentPreviewPort.execute(studentId);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/stay/approve/{document-id}")
    public void approveStayDocument(@PathVariable("document-id") @NotBlank UUID documentId) {
        approveStayDocumentPort.execute(documentId);
    }
}
