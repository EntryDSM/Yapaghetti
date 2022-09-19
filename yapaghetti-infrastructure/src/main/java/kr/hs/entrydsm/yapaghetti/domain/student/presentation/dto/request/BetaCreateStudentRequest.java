package kr.hs.entrydsm.yapaghetti.domain.student.presentation.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class BetaCreateStudentRequest {

	@Email
	@NotBlank
	private String email;

	@Max(4)
	@NotNull
	private int classNum;

	@Max(20)
	@NotNull
	private int number;

	@Length(max = 10)
	@NotBlank
	private String name;

	@Length(max = 11)
	@NotBlank
	private String phoneNumber;
}
