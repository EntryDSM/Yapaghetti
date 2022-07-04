package kr.hs.entrydsm.yapaghetti.domain.tag.api;

import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.response.DomainTagListResponse;

public interface GetTagListPort {
    public DomainTagListResponse execute(String name, boolean isMajor);
}
