package kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class StudentElement {

    private final UUID studentId;

    private final String major;

    private final List<String> tagList;

    private final String name;

    private final String gcn;

    private final String previewImagePath;

    private final String profileImagePath;

}
