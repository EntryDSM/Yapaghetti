package kr.hs.entrydsm.yapaghetti.domain.tag.api;

import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainAddTagRequest;

public interface AddTagPort {

    void execute(DomainAddTagRequest request);

}
