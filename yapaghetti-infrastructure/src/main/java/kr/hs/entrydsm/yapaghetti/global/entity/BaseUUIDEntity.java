package kr.hs.entrydsm.yapaghetti.global.entity;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class BaseUUIDEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "public_uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID publicId;
}
