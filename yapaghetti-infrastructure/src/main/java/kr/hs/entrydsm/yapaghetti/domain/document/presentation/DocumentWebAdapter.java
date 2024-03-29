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
import kr.hs.entrydsm.yapaghetti.domain.document.api.RejectStayDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.RequestLocalDocumentToPublicPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.ReturnPublicDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.UpdateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.UpdateStayDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainCreateDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainUpdateStayDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response.CreateLocalDocumentResponse;
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
import javax.validation.constraints.NotNull;
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
    private final RejectStayDocumentPort rejectStayDocumentPort;
    private final UpdateStayDocumentPort updateStayDocumentPort;
    private final QueryLocalDocumentListPort queryLocalDocumentListPort;
    private final QueryStayAndPublicDocumentPreviewPort queryStayAndPublicDocumentPreviewPort;
    private final ApproveStayDocumentPort approveStayDocumentPort;
    private final ReturnPublicDocumentPort returnPublicDocumentPort;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateLocalDocumentResponse createLocalDocument(@RequestBody @Valid WebCreateLocalDocumentRequest request) {
        return createLocalDocumentPort.execute(
                new DomainCreateDocumentRequest(
                        request.getContent(),
                        request.getPreviewImagePath()
                )
        );
    }

    @GetMapping("/public/{student-id}")
    public QueryDocumentResponse getPublicDocument(@PathVariable("student-id") @NotNull UUID studentId) {
        return queryPublicDocumentPort.execute(studentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/copy")
    public void copyPublicDocumentToLocal() {
        copyPublicDocumentPort.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{document-id}")
    public void updateLocalDocument(@PathVariable("document-id") @NotNull UUID documentId,
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
    public void deletePublicDocument(@PathVariable("student-id") @NotNull UUID userId) {
        deletePublicDocumentPort.execute(userId);
    }

    @GetMapping("/{document-id}")
    public QueryDocumentResponse getLocalDocument(@PathVariable("document-id") @NotNull UUID documentId) {
        return queryLocalDocumentPort.execute(documentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{document-id}")
    public void deleteLocalDocument(@PathVariable("document-id") @NotNull UUID documentId) {
        deleteLocalDocumentPort.execute(documentId);
    }

    @GetMapping("/stay/{student-id}")
    public QueryStayDocumentResponse getStayDocument(@PathVariable("student-id") @NotNull UUID studentId) {
        return queryStayDocumentPort.execute(studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/cancel/{student-id}")
    public void cancelStayDocument(@PathVariable("student-id") @NotNull UUID studentId) {
        cancelStayDocumentPort.execute(studentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{document-id}")
    public void requestLocalDocumentToPublic(@PathVariable("document-id") @NotNull UUID documentId) {
        requestLocalDocumentToPublicPort.execute(documentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/stay/reject/{student-id}")
    public void rejectStayDocument(@PathVariable("student-id") @NotNull UUID studentId) {
        rejectStayDocumentPort.execute(studentId);
    }

    @PatchMapping("/stay")
    public void updateStayDocument(@RequestBody @Valid WebUpdateStayDocumentRequest request) {
        updateStayDocumentPort.execute(
                new DomainUpdateStayDocumentRequest(request.getPreviewImagePath(), request.getContent())
        );
    }

    @GetMapping("/lists")
    public QueryLocalDocumentListResponse getLocalDocumentList() {
        return queryLocalDocumentListPort.execute();
    }

    @GetMapping("/preview/{student-id}")
    public QueryStayAndPublicDocumentPreviewResponse getStayAndPublicDocumentList(@PathVariable("student-id") @NotNull UUID studentId) {
        return queryStayAndPublicDocumentPreviewPort.execute(studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/stay/approve/{student-id}")
    public void approveStayDocument(@PathVariable("student-id") @NotNull UUID documentId) {
        approveStayDocumentPort.execute(documentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/return/{student-id}")
    public void returnDocument(@PathVariable("student-id") @NotNull UUID studentId) {
        returnPublicDocumentPort.execute(studentId);
    }
}
