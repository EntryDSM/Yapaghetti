package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import java.util.UUID;

public interface QueryTagPort {
    boolean existByName(String name);
    boolean existsById(UUID tagId);
}
