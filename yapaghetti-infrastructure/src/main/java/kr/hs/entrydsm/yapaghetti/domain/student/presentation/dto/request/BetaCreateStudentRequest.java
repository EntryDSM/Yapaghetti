package kr.hs.entrydsm.yapaghetti.domain.student.presentation.dto.request;

import java.util.UUID;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BetaCreateStudentRequest {

    @Email
    @NotBlank
    private String email;

    @Size(max = 10)
    @NotBlank
    private String name;

    @Size(max = 11)
    @NotBlank
    private String phoneNumber;

    @Max(4)
    @NotNull
    private int grade;

    @Max(4)
    @NotNull
    private int classNum;

    @Max(20)
    @NotNull
    private int number;

    @NotBlank
    private String location;

    @NotNull
    private UUID tagId;
}
