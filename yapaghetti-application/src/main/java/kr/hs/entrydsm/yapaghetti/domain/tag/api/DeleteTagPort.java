package kr.hs.entrydsm.yapaghetti.domain.tag.api;

import java.util.UUID;

public interface DeleteTagPort {
    void execute(UUID tagId);
}
