package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.student.api.BetaCreateUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response.BetaCreateUserResponse;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.CommandStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentCommandUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentRandomStringPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class BetaCreateUserUseCase implements BetaCreateUserPort {

    private final StudentCommandUserPort studentCommandUserPort;
    private final StudentQueryUserPort studentQueryUserPort;
    private final StudentRandomStringPort studentRandomStringPort;
    private final CommandStudentPort commandStudentPort;
    private final StudentSecurityPort studentSecurityPort;

    @Override
    public BetaCreateUserResponse execute(
            String email, int grade, int classNum, int number,
            String name, String phoneNumber, String location, UUID tagId
    ) {
        if (studentQueryUserPort.existsUserByEmail(email)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        String password = studentRandomStringPort.getRandomPassword();
        String encodedPassword = studentSecurityPort.encodePassword(password);

        User user = User.builder()
                .email(email)
                .password(encodedPassword)
                .name(name)
                .profileImagePath("https://s3.ap-northeast-2.amazonaws.com/image.entrydsm.hs.kr/repo/profile/a1010c27-8ba1-413d-bee8-c1b0d0e4af71.png")
                .phoneNumber(phoneNumber)
                .location(location)
                .role(UserRole.STUDENT)
                .isVisited(false)
                .build();
        UUID userId = studentCommandUserPort.saveUserAndGetId(user);

        Student student = Student.builder()
                .userId(userId)
                .grade(grade)
                .classNum(classNum)
                .number(number)
                .tagId(tagId)
                .build();
        commandStudentPort.saveStudent(student);

        return BetaCreateUserResponse.builder()
                .email(email)
                .password(password)
                .build();
    }
}
