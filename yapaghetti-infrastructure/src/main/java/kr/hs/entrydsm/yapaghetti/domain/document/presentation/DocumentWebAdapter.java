package kr.hs.entrydsm.yapaghetti.domain.document.presentation;

import kr.hs.entrydsm.yapaghetti.domain.document.api.CreateLocalDocumentPort;
import kr.hs.entrydsm.yapaghetti.domain.document.api.dto.request.DomainCreateLocalDocumentRequest;
import kr.hs.entrydsm.yapaghetti.domain.document.presentation.dto.request.WebCreateLocalDocumentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/documents")
@RestController
public class DocumentWebAdapter {

    private final CreateLocalDocumentPort createLocalDocumentPort;

    @PostMapping
    public void createLocalDocument(WebCreateLocalDocumentRequest request) {
        createLocalDocumentPort.createLocalDocument(
                DomainCreateLocalDocumentRequest.builder()
                        .previewImagePath(request.getPreviewImagePath())
                        .content(request.getContent())
                        .build()
        );
    }
}
