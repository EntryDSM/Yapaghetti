package kr.hs.entrydsm.yapaghetti.domain.tag.api;

import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainSetMajorTagRequest;

public interface SetMajorTagPort {

    void execute(DomainSetMajorTagRequest request);

}
