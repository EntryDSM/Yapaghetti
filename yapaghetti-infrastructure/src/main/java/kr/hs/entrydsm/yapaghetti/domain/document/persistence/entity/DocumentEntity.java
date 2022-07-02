package kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity;

import kr.hs.entrydsm.yapaghetti.domain.document.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import kr.hs.entrydsm.yapaghetti.global.entity.BaseIDEntity;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_document")
public class DocumentEntity extends BaseIDEntity {

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String previewImagePath;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(9)", nullable = false)
    private DocumentType type;

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID publicId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

}
