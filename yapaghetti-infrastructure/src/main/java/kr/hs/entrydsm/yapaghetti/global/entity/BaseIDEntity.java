package kr.hs.entrydsm.yapaghetti.global.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
@Getter
@MappedSuperclass
public abstract class BaseIDEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
