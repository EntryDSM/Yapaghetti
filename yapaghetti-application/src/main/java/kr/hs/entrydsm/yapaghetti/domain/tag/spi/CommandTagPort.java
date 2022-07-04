package kr.hs.entrydsm.yapaghetti.domain.tag.spi;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;

public interface CommandTagPort {
    void saveTag(Tag tag);
}
