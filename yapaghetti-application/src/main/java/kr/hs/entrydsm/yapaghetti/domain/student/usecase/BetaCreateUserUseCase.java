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
	public BetaCreateUserResponse execute(String email, int classNum, int number, String name, String phoneNumber) {
		if (studentQueryUserPort.existsUserByEmail(email)) {
			throw UserAlreadyExistsException.EXCEPTION;
		}

		String password = studentRandomStringPort.getRandomPassword();
		String encodedPassword = studentSecurityPort.encodePassword(password);

		User user = User.builder()
			.email(email)
			.password(encodedPassword)
			.name(name)
			.location("대덕소프트웨어마이스터고")
			.role(UserRole.STUDENT)
			.profileImagePath("https://s3.ap-northeast-2.amazonaws.com/image.entrydsm.hs.kr/repo/profile/69274ca6-55ee-4d3e-898a-107225c3fb05.jpeg")
			.isVisited(false)
			.phoneNumber(phoneNumber)
			.build();
		studentCommandUserPort.saveUser(user);

		UUID id = studentQueryUserPort.queryUserByEmail(email).getId();

		Student student = Student.builder()
			.userId(id)
			.grade(2)
			.classNum(classNum)
			.number(number)
			.tagId(UUID.fromString("71c60818-be4a-4a2f-9329-92cd1d2aec0e"))
			.build();
		commandStudentPort.saveStudent(student);

		return BetaCreateUserResponse.builder()
			.email(email)
			.password(password)
			.build();
	}
}
