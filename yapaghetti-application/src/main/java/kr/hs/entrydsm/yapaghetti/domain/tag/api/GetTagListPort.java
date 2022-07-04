package kr.hs.entrydsm.yapaghetti.domain.tag.api;

import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.response.TagListResponse;

public interface GetTagListPort {
    public TagListResponse execute(String name, boolean isMajor);
}
