# yapaghetti

### Project Structure
```.
├── Dockerfile
├── LICENSE
├── README.md
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
├── yapaghetti-application
│   ├── build.gradle
│   └── src
│       ├── main
│       │   └── java
│       │       └── kr
│       │           └── hs
│       │               └── entrydsm
│       │                   └── yapaghetti
│       │                       ├── annotation
│       │                       │   ├── Aggregate.java
│       │                       │   ├── ReadOnlyUseCase.java
│       │                       │   └── UseCase.java
│       │                       ├── domain
│       │                       │   ├── auth
│       │                       │   │   ├── api
│       │                       │   │   │   ├── SendEmailAuthCodePort.java
│       │                       │   │   │   ├── SendPhoneNumberAuthCodePort.java
│       │                       │   │   │   └── VerifyAuthCodePort.java
│       │                       │   │   ├── domain
│       │                       │   │   │   └── AuthCode.java
│       │                       │   │   ├── error
│       │                       │   │   │   └── AuthCodeErrorCode.java
│       │                       │   │   ├── exception
│       │                       │   │   │   ├── AuthCodeAlreadyTimeOutException.java
│       │                       │   │   │   ├── AuthCodeAlreadyVerifiedException.java
│       │                       │   │   │   ├── AuthCodeNotFoundException.java
│       │                       │   │   │   ├── AuthCodeNotVerifiedException.java
│       │                       │   │   │   ├── AuthCodeOverLimitException.java
│       │                       │   │   │   └── InvalidAuthCodeException.java
│       │                       │   │   ├── spi
│       │                       │   │   │   ├── AuthCodePort.java
│       │                       │   │   │   ├── AuthQueryUserPort.java
│       │                       │   │   │   ├── AuthSecurityPort.java
│       │                       │   │   │   ├── CommandAuthCodePort.java
│       │                       │   │   │   ├── GenerateRandomStringPort.java
│       │                       │   │   │   ├── GetAuthPropertiesPort.java
│       │                       │   │   │   ├── QueryAuthCodePort.java
│       │                       │   │   │   ├── RandomStringPort.java
│       │                       │   │   │   ├── SendMailPort.java
│       │                       │   │   │   └── SendSmsPort.java
│       │                       │   │   └── usecase
│       │                       │   │       ├── SendEmailAuthCodeUseCase.java
│       │                       │   │       ├── SendPhoneNumberAuthCodeUseCase.java
│       │                       │   │       └── VerifyAuthCodeUseCase.java
│       │                       │   ├── company
│       │                       │   │   ├── api
│       │                       │   │   │   ├── QueryStudentListPort.java
│       │                       │   │   │   ├── UpdateCompanyNamePort.java
│       │                       │   │   │   └── dto
│       │                       │   │   │       ├── request
│       │                       │   │   │       │   ├── DomainQueryStudentListRequest.java
│       │                       │   │   │       │   └── DomainUpdateCompanyNameRequest.java
│       │                       │   │   │       └── response
│       │                       │   │   │           ├── QueryStudentListResponse.java
│       │                       │   │   │           └── StudentElement.java
│       │                       │   │   ├── domain
│       │                       │   │   │   └── Company.java
│       │                       │   │   ├── error
│       │                       │   │   │   └── CompanyErrorCode.java
│       │                       │   │   ├── exception
│       │                       │   │   │   └── CompanyNotFoundException.java
│       │                       │   │   ├── spi
│       │                       │   │   │   ├── CommandCompanyPort.java
│       │                       │   │   │   ├── CompanyPort.java
│       │                       │   │   │   ├── CompanyQueryStudentPort.java
│       │                       │   │   │   ├── CompanySecurityPort.java
│       │                       │   │   │   └── QueryCompanyPort.java
│       │                       │   │   └── usecase
│       │                       │   │       ├── QueryStudentListUseCase.java
│       │                       │   │       └── UpdateCompanyNameUseCase.java
│       │                       │   ├── document
│       │                       │   │   ├── api
│       │                       │   │   │   ├── ApproveStayDocumentPort.java
│       │                       │   │   │   ├── CancelStayDocumentPort.java
│       │                       │   │   │   ├── CopyPublicDocumentPort.java
│       │                       │   │   │   ├── CreateLocalDocumentPort.java
│       │                       │   │   │   ├── DeleteLocalDocumentPort.java
│       │                       │   │   │   ├── DeletePublicDocumentPort.java
│       │                       │   │   │   ├── QueryLocalDocumentListPort.java
│       │                       │   │   │   ├── QueryLocalDocumentPort.java
│       │                       │   │   │   ├── QueryProtectedDocumentUrlPort.java
│       │                       │   │   │   ├── QueryPublicDocumentPort.java
│       │                       │   │   │   ├── QueryStayAndPublicDocumentPreviewPort.java
│       │                       │   │   │   ├── QueryStayDocumentPort.java
│       │                       │   │   │   ├── RejectStayDocumentPort.java
│       │                       │   │   │   ├── RequestLocalDocumentToPublicPort.java
│       │                       │   │   │   ├── UpdateLocalDocumentPort.java
│       │                       │   │   │   ├── UpdateStayDocumentPort.java
│       │                       │   │   │   └── dto
│       │                       │   │   │       ├── request
│       │                       │   │   │       │   ├── DomainCreateLocalDocumentRequest.java
│       │                       │   │   │       │   ├── DomainUpdateLocalDocumentRequest.java
│       │                       │   │   │       │   └── DomainUpdateStayDocumentRequest.java
│       │                       │   │   │       └── response
│       │                       │   │   │           ├── DocumentElement.java
│       │                       │   │   │           ├── FeedbackElement.java
│       │                       │   │   │           ├── QueryDocumentResponse.java
│       │                       │   │   │           ├── QueryLocalDocumentListResponse.java
│       │                       │   │   │           ├── QueryProtectedDocumentUrlResponse.java
│       │                       │   │   │           ├── QueryStayAndPublicDocumentPreviewResponse.java
│       │                       │   │   │           ├── QueryStayDocumentResponse.java
│       │                       │   │   │           └── StayAndPublicDocumentElement.java
│       │                       │   │   ├── domain
│       │                       │   │   │   ├── Document.java
│       │                       │   │   │   └── DocumentType.java
│       │                       │   │   ├── error
│       │                       │   │   │   └── DocumentErrorCode.java
│       │                       │   │   ├── exception
│       │                       │   │   │   └── DocumentNotFoundException.java
│       │                       │   │   ├── spi
│       │                       │   │   │   ├── CommandDocumentPort.java
│       │                       │   │   │   ├── DocumentPort.java
│       │                       │   │   │   ├── DocumentQueryFeedbackPort.java
│       │                       │   │   │   ├── DocumentQueryStudentPort.java
│       │                       │   │   │   ├── DocumentQueryTagPort.java
│       │                       │   │   │   ├── DocumentQueryUserPort.java
│       │                       │   │   │   ├── DocumentSecurityPort.java
│       │                       │   │   │   └── QueryDocumentPort.java
│       │                       │   │   └── usecase
│       │                       │   │       ├── ApproveStayDocumentUseCase.java
│       │                       │   │       ├── CancelStayDocumentUseCase.java
│       │                       │   │       ├── CopyPublicDocumentUseCase.java
│       │                       │   │       ├── CreateLocalDocumentUseCase.java
│       │                       │   │       ├── DeleteLocalDocumentUseCase.java
│       │                       │   │       ├── DeletePublicDocumentUseCase.java
│       │                       │   │       ├── QueryLocalDocumentListUseCase.java
│       │                       │   │       ├── QueryLocalDocumentUseCase.java
│       │                       │   │       ├── QueryProtectedDocumentUrlUseCase.java
│       │                       │   │       ├── QueryPublicDocumentUseCase.java
│       │                       │   │       ├── QueryStayAndPublicDocumentPreviewUseCase.java
│       │                       │   │       ├── QueryStayDocumentUseCase.java
│       │                       │   │       ├── RejectStayDocumentUseCase.java
│       │                       │   │       ├── RequestLocalDocumentToPublicUseCase.java
│       │                       │   │       ├── UpdateLocalDocumentUseCase.java
│       │                       │   │       └── UpdateStayDocumentUseCase.java
│       │                       │   ├── feedback
│       │                       │   │   ├── domain
│       │                       │   │   │   └── Feedback.java
│       │                       │   │   ├── error
│       │                       │   │   │   └── FeedbackErrorCode.java
│       │                       │   │   ├── exception
│       │                       │   │   │   └── FeedbackNotFoundException.java
│       │                       │   │   └── spi
│       │                       │   │       ├── CommandFeedbackPort.java
│       │                       │   │       └── FeedbackPort.java
│       │                       │   ├── image
│       │                       │   │   ├── api
│       │                       │   │   │   ├── UploadImagePort.java
│       │                       │   │   │   └── dto
│       │                       │   │   │       └── response
│       │                       │   │   │           └── ImageUrlResponse.java
│       │                       │   │   ├── error
│       │                       │   │   │   └── ImageErrorCode.java
│       │                       │   │   ├── exception
│       │                       │   │   │   ├── ImageExtensionInvalidException.java
│       │                       │   │   │   └── ImageNotFoundException.java
│       │                       │   │   ├── spi
│       │                       │   │   │   ├── UploadS3Port.java
│       │                       │   │   │   └── type
│       │                       │   │   │       └── ImageType.java
│       │                       │   │   └── usecase
│       │                       │   │       └── UploadImageUseCase.java
│       │                       │   ├── my_skill
│       │                       │   │   ├── domain
│       │                       │   │   │   └── MySkill.java
│       │                       │   │   └── spi
│       │                       │   │       └── MySkillPort.java
│       │                       │   ├── student
│       │                       │   │   ├── api
│       │                       │   │   │   ├── QueryMyInfoPort.java
│       │                       │   │   │   ├── ReflectFeedbackPort.java
│       │                       │   │   │   ├── UpdateMyInfoPort.java
│       │                       │   │   │   └── dto
│       │                       │   │   │       └── response
│       │                       │   │   │           └── MyInfoResponse.java
│       │                       │   │   ├── domain
│       │                       │   │   │   ├── Student.java
│       │                       │   │   │   └── UpdateType.java
│       │                       │   │   ├── error
│       │                       │   │   │   └── StudentErrorCode.java
│       │                       │   │   ├── exception
│       │                       │   │   │   └── StudentNotFoundException.java
│       │                       │   │   ├── spi
│       │                       │   │   │   ├── CommandStudentPort.java
│       │                       │   │   │   ├── QueryStudentPort.java
│       │                       │   │   │   ├── StudentCommandUserPort.java
│       │                       │   │   │   ├── StudentPort.java
│       │                       │   │   │   ├── StudentQueryAuthCodePort.java
│       │                       │   │   │   ├── StudentQueryDocumentPort.java
│       │                       │   │   │   ├── StudentQueryFeedbackPort.java
│       │                       │   │   │   ├── StudentQueryMySkillPort.java
│       │                       │   │   │   ├── StudentQueryTagPort.java
│       │                       │   │   │   ├── StudentQueryUserPort.java
│       │                       │   │   │   └── StudentSecurityPort.java
│       │                       │   │   └── usecase
│       │                       │   │       ├── QueryMyInfoUseCase.java
│       │                       │   │       ├── ReflectFeedbackUseCase.java
│       │                       │   │       └── UpdateMyInfoUseCase.java
│       │                       │   ├── tag
│       │                       │   │   ├── api
│       │                       │   │   │   ├── AddMySkillPort.java
│       │                       │   │   │   ├── AddTagPort.java
│       │                       │   │   │   ├── DeleteTagPort.java
│       │                       │   │   │   ├── QueryTagListPort.java
│       │                       │   │   │   ├── SetMajorTagPort.java
│       │                       │   │   │   └── dto
│       │                       │   │   │       ├── request
│       │                       │   │   │       │   ├── DomainAddMySkillRequest.java
│       │                       │   │   │       │   ├── DomainAddTagRequest.java
│       │                       │   │   │       │   └── DomainSetMajorTagRequest.java
│       │                       │   │   │       └── response
│       │                       │   │   │           ├── TagElement.java
│       │                       │   │   │           └── TagListResponse.java
│       │                       │   │   ├── domain
│       │                       │   │   │   ├── Tag.java
│       │                       │   │   │   └── TagType.java
│       │                       │   │   ├── error
│       │                       │   │   │   └── TagErrorCode.java
│       │                       │   │   ├── exception
│       │                       │   │   │   ├── AlreadyExistsTagException.java
│       │                       │   │   │   ├── TagNotFoundException.java
│       │                       │   │   │   └── UnableDeleteTagException.java
│       │                       │   │   ├── spi
│       │                       │   │   │   ├── CommandTagPort.java
│       │                       │   │   │   ├── QueryTagPort.java
│       │                       │   │   │   ├── TagCommandMySkillPort.java
│       │                       │   │   │   ├── TagPort.java
│       │                       │   │   │   ├── TagQueryStudentPort.java
│       │                       │   │   │   └── TagSecurityPort.java
│       │                       │   │   └── usecase
│       │                       │   │       ├── AddMySkillUseCase.java
│       │                       │   │       ├── AddTagUseCase.java
│       │                       │   │       ├── DeleteTagUseCase.java
│       │                       │   │       ├── QueryTagListUseCase.java
│       │                       │   │       └── SetMajorTagUseCase.java
│       │                       │   ├── teacher
│       │                       │   │   ├── api
│       │                       │   │   │   ├── ChangeCompanyPasswordPort.java
│       │                       │   │   │   ├── CreateCompanyPort.java
│       │                       │   │   │   ├── CreateFeedbackPort.java
│       │                       │   │   │   ├── DeleteCompanyPort.java
│       │                       │   │   │   ├── DeleteStudentPort.java
│       │                       │   │   │   ├── GetCompanyDetailPort.java
│       │                       │   │   │   ├── QueryCompanyListPort.java
│       │                       │   │   │   ├── QueryStudentDetailPort.java
│       │                       │   │   │   ├── TeacherQueryStudentListPort.java
│       │                       │   │   │   ├── UpdateCompanyPort.java
│       │                       │   │   │   └── dto
│       │                       │   │   │       ├── request
│       │                       │   │   │       │   ├── DomainCreateFeedbackRequest.java
│       │                       │   │   │       │   ├── DomainNewCompanyRequest.java
│       │                       │   │   │       │   └── DomainUpdateCompanyRequest.java
│       │                       │   │   │       └── response
│       │                       │   │   │           ├── ChangeCompanyPasswordResponse.java
│       │                       │   │   │           ├── CompanyDetailResponse.java
│       │                       │   │   │           ├── CompanyElement.java
│       │                       │   │   │           ├── CompanyListResponse.java
│       │                       │   │   │           ├── NewCompanyResponse.java
│       │                       │   │   │           ├── StudentDetailResponse.java
│       │                       │   │   │           ├── StudentElementByGradeClassNum.java
│       │                       │   │   │           └── StudentListResponse.java
│       │                       │   │   ├── spi
│       │                       │   │   │   ├── CommandTeacherPort.java
│       │                       │   │   │   ├── QueryTeacherPort.java
│       │                       │   │   │   ├── TeacherCommandCompanyPort.java
│       │                       │   │   │   ├── TeacherCommandStudentPort.java
│       │                       │   │   │   ├── TeacherCommandUserPort.java
│       │                       │   │   │   ├── TeacherPort.java
│       │                       │   │   │   ├── TeacherQueryCompanyPort.java
│       │                       │   │   │   ├── TeacherQueryStudentPort.java
│       │                       │   │   │   ├── TeacherQueryUserPort.java
│       │                       │   │   │   ├── TeacherRandomStringPort.java
│       │                       │   │   │   └── TeacherSecurityPort.java
│       │                       │   │   └── usecase
│       │                       │   │       ├── ChangeCompanyPasswordUseCase.java
│       │                       │   │       ├── CreateCompanyUseCase.java
│       │                       │   │       ├── CreateFeedbackUseCase.java
│       │                       │   │       ├── DeleteCompanyUseCase.java
│       │                       │   │       ├── DeleteStudentUseCase.java
│       │                       │   │       ├── GetCompanyDetailUseCase.java
│       │                       │   │       ├── QueryCompanyListUseCase.java
│       │                       │   │       ├── QueryStudentDetailUseCase.java
│       │                       │   │       ├── TeacherQueryStudentListUseCase.java
│       │                       │   │       └── UpdateCompanyUseCase.java
│       │                       │   └── user
│       │                       │       ├── api
│       │                       │       │   ├── FirstPasswordUpdatePort.java
│       │                       │       │   ├── SignInPort.java
│       │                       │       │   ├── TokenRefreshPort.java
│       │                       │       │   ├── UpdateUserInformationPort.java
│       │                       │       │   └── dto
│       │                       │       │       ├── request
│       │                       │       │       │   ├── DomainFirstPasswordUpdateRequest.java
│       │                       │       │       │   ├── DomainSignInRequest.java
│       │                       │       │       │   └── DomainUpdateUserInformationRequest.java
│       │                       │       │       └── response
│       │                       │       │           ├── SignInResponse.java
│       │                       │       │           └── TokenRefreshResponse.java
│       │                       │       ├── domain
│       │                       │       │   ├── RefreshToken.java
│       │                       │       │   ├── User.java
│       │                       │       │   └── UserRole.java
│       │                       │       ├── error
│       │                       │       │   └── UserErrorCode.java
│       │                       │       ├── exception
│       │                       │       │   ├── RefreshTokenNotFoundException.java
│       │                       │       │   ├── UserInvalidPasswordException.java
│       │                       │       │   ├── UserInvalidRoleException.java
│       │                       │       │   └── UserNotFoundException.java
│       │                       │       ├── spi
│       │                       │       │   ├── CommandRefreshTokenPort.java
│       │                       │       │   ├── CommandUserPort.java
│       │                       │       │   ├── QueryRefreshTokenPort.java
│       │                       │       │   ├── QueryUserPort.java
│       │                       │       │   ├── RefreshTokenPort.java
│       │                       │       │   ├── UserJwtPort.java
│       │                       │       │   ├── UserPort.java
│       │                       │       │   ├── UserSecurityPort.java
│       │                       │       │   └── dto
│       │                       │       │       └── SpiTokenResponse.java
│       │                       │       └── usecase
│       │                       │           ├── FirstPasswordUpdateUseCase.java
│       │                       │           ├── SignInUseCase.java
│       │                       │           ├── TokenRefreshUseCase.java
│       │                       │           └── UpdateUserInformationUseCase.java
│       │                       └── error
│       │                           ├── ErrorProperty.java
│       │                           └── YapaghettiException.java
│       └── test
│           └── java
│               └── kr
│                   └── hs
│                       └── entrydsm
│                           └── yapaghetti
│                               └── domain
│                                   ├── auth
│                                   │   └── usecase
│                                   │       ├── SendEmailAuthCodeUseCaseTest.java
│                                   │       ├── SendPhoneNumberAuthCodeUseCaseTest.java
│                                   │       └── VerifyAuthCodeUseCaseTest.java
│                                   ├── company
│                                   │   └── usecase
│                                   │       ├── QueryStudentListUseCaseTest.java
│                                   │       └── UpdateCompanyNameUseCaseTest.java
│                                   ├── document
│                                   │   └── usecase
│                                   │       ├── ApproveStayDocumentUseCaseTest.java
│                                   │       ├── CancelStayDocumentUseCaseTest.java
│                                   │       ├── CopyPublicDocumentUseCaseTest.java
│                                   │       ├── CreateLocalDocumentUseCaseTest.java
│                                   │       ├── DeleteLocalDocumentUseCaseTest.java
│                                   │       ├── DeletePublicDocumentUseCaseTest.java
│                                   │       ├── QueryLocalDocumentListUseCaseTest.java
│                                   │       ├── QueryLocalDocumentUseCaseTest.java
│                                   │       ├── QueryProtectedDocumentUrlUseCaseTest.java
│                                   │       ├── QueryPublicDocumentUseCaseTest.java
│                                   │       ├── QueryStayAndPublicDocumentPreviewUseCaseTest.java
│                                   │       ├── QueryStayDocumentUseCaseTest.java
│                                   │       ├── RejectStayDocumentUseCaseTest.java
│                                   │       ├── RequestLocalDocumentToPublicUseCaseTest.java
│                                   │       ├── UpdateLocalDocumentUseCaseTest.java
│                                   │       └── UpdateStayDocumentUseCaseTest.java
│                                   ├── image
│                                   │   └── usecase
│                                   │       └── UploadImageUseCaseTest.java
│                                   ├── student
│                                   │   └── usecase
│                                   │       ├── GetMyInfoUseCaseTest.java
│                                   │       ├── ReflectFeedbackUseCaseTest.java
│                                   │       └── UpdateMyInfoUseCaseTest.java
│                                   ├── tag
│                                   │   └── usecase
│                                   │       ├── AddMySkillUseCaseTest.java
│                                   │       ├── AddTagUseCaseTest.java
│                                   │       ├── DeleteTagUseCaseTest.java
│                                   │       ├── QueryTagListUseCaseTest.java
│                                   │       └── SetMajorTagUseCaseTest.java
│                                   ├── teacher
│                                   │   └── usecase
│                                   │       ├── CreateCompanyUseCaseTest.java
│                                   │       ├── CreateFeedbackUseCaseTest.java
│                                   │       ├── DeleteCompanyUseCaseTest.java
│                                   │       ├── DeleteStudentUseCaseTest.java
│                                   │       ├── GetCompanyDetailUseCaseTest.java
│                                   │       ├── QueryCompanyListTest.java
│                                   │       ├── QueryStudentDetailTest.java
│                                   │       ├── ResetPasswordTest.java
│                                   │       ├── TeacherQueryStudentListTest.java
│                                   │       └── UpdateCompanyTest.java
│                                   └── user
│                                       └── usecase
│                                           ├── FirstPasswordUpdateUseCaseTest.java
│                                           ├── SignInUseCaseTest.java
│                                           ├── TokenRefreshUseCaseTest.java
│                                           └── UpdateUserInformationUseCaseTest.java
└── yapaghetti-infrastructure
    ├── build.gradle
    └── src
        └── main
            ├── java
            │   └── kr
            │       └── hs
            │           └── entrydsm
            │               └── yapaghetti
            │                   ├── YapaghettiApplication.java
            │                   ├── domain
            │                   │   ├── auth
            │                   │   │   ├── mapper
            │                   │   │   │   └── AuthCodeMapper.java
            │                   │   │   ├── persistence
            │                   │   │   │   ├── AuthCodePersistenceAdapter.java
            │                   │   │   │   ├── AuthCodeRepository.java
            │                   │   │   │   └── entity
            │                   │   │   │       └── AuthCodeEntity.java
            │                   │   │   └── presentation
            │                   │   │       └── AuthWebAdapter.java
            │                   │   ├── company
            │                   │   │   ├── mapper
            │                   │   │   │   └── CompanyMapper.java
            │                   │   │   ├── persistence
            │                   │   │   │   ├── CompanyPersistenceAdapter.java
            │                   │   │   │   ├── CompanyRepository.java
            │                   │   │   │   └── entity
            │                   │   │   │       └── CompanyEntity.java
            │                   │   │   └── presentation
            │                   │   │       ├── CompanyWebAdapter.java
            │                   │   │       └── dto
            │                   │   │           └── request
            │                   │   │               └── WebUpdateCompanyNameRequest.java
            │                   │   ├── document
            │                   │   │   ├── mapper
            │                   │   │   │   └── DocumentMapper.java
            │                   │   │   ├── persistence
            │                   │   │   │   ├── DocumentPersistenceAdapter.java
            │                   │   │   │   ├── DocumentRepository.java
            │                   │   │   │   └── entity
            │                   │   │   │       └── DocumentEntity.java
            │                   │   │   └── presentation
            │                   │   │       ├── DocumentWebAdapter.java
            │                   │   │       └── dto
            │                   │   │           └── request
            │                   │   │               ├── WebCreateLocalDocumentRequest.java
            │                   │   │               ├── WebUpdateLocalDocumentRequest.java
            │                   │   │               └── WebUpdateStayDocumentRequest.java
            │                   │   ├── feedback
            │                   │   │   ├── mapper
            │                   │   │   │   └── FeedbackMapper.java
            │                   │   │   └── persistence
            │                   │   │       ├── FeedbackPersistenceAdapter.java
            │                   │   │       ├── FeedbackRepository.java
            │                   │   │       └── entity
            │                   │   │           ├── FeedbackEntity.java
            │                   │   │           └── FeedbackEntityId.java
            │                   │   ├── image
            │                   │   │   └── presentation
            │                   │   │       └── ImageWebAdapter.java
            │                   │   ├── my_skill
            │                   │   │   ├── mapper
            │                   │   │   │   └── MySkillMapper.java
            │                   │   │   └── persistence
            │                   │   │       ├── MySkillPersistenceAdapter.java
            │                   │   │       ├── MySkillRepository.java
            │                   │   │       └── entity
            │                   │   │           ├── MySkillEntity.java
            │                   │   │           └── MySkillEntityId.java
            │                   │   ├── student
            │                   │   │   ├── mapper
            │                   │   │   │   └── StudentMapper.java
            │                   │   │   ├── persistence
            │                   │   │   │   ├── StudentPersistenceAdapter.java
            │                   │   │   │   ├── StudentRepository.java
            │                   │   │   │   └── entity
            │                   │   │   │       └── StudentEntity.java
            │                   │   │   └── presentation
            │                   │   │       └── StudentWebAdapter.java
            │                   │   ├── tag
            │                   │   │   ├── mapper
            │                   │   │   │   └── TagMapper.java
            │                   │   │   ├── persistence
            │                   │   │   │   ├── TagPersistenceAdapter.java
            │                   │   │   │   ├── TagRepository.java
            │                   │   │   │   └── entity
            │                   │   │   │       └── TagEntity.java
            │                   │   │   └── presentation
            │                   │   │       ├── TagWebAdapter.java
            │                   │   │       └── dto
            │                   │   │           └── request
            │                   │   │               ├── WebAddMySkillRequest.java
            │                   │   │               ├── WebAddTagRequest.java
            │                   │   │               └── WebSetMajorTagRequest.java
            │                   │   ├── teacher
            │                   │   │   ├── persistence
            │                   │   │   │   ├── TeacherPersistenceAdapter.java
            │                   │   │   │   ├── TeacherRepository.java
            │                   │   │   │   └── entity
            │                   │   │   │       └── TeacherEntity.java
            │                   │   │   └── presentation
            │                   │   │       ├── TeacherWebAdapter.java
            │                   │   │       └── dto
            │                   │   │           └── request
            │                   │   │               ├── WebCreateCompanyRequest.java
            │                   │   │               ├── WebCreateFeedbackRequest.java
            │                   │   │               └── WebUpdateCompanyRequest.java
            │                   │   └── user
            │                   │       ├── mapper
            │                   │       │   ├── RefreshTokenMapper.java
            │                   │       │   └── UserMapper.java
            │                   │       ├── persistence
            │                   │       │   ├── RefreshTokenPersistenceAdapter.java
            │                   │       │   ├── RefreshTokenRepository.java
            │                   │       │   ├── UserPersistenceAdapter.java
            │                   │       │   ├── UserQuerydslExtension.java
            │                   │       │   ├── UserQuerydslImpl.java
            │                   │       │   ├── UserRepository.java
            │                   │       │   └── entity
            │                   │       │       ├── RefreshTokenEntity.java
            │                   │       │       └── UserEntity.java
            │                   │       └── presentation
            │                   │           ├── UserWebAdapter.java
            │                   │           └── dto
            │                   │               └── request
            │                   │                   ├── WebFirstPasswordUpdateRequest.java
            │                   │                   ├── WebSignInRequest.java
            │                   │                   └── WebUpdateUserInformationRequest.java
            │                   ├── global
            │                   │   ├── annotation
            │                   │   │   ├── Adapter.java
            │                   │   │   └── config
            │                   │   │       └── GlobalComponentScan.java
            │                   │   ├── aop
            │                   │   │   └── TransactionAspect.java
            │                   │   ├── config
            │                   │   │   ├── FilterConfig.java
            │                   │   │   └── WebConfig.java
            │                   │   ├── entity
            │                   │   │   └── BaseUUIDEntity.java
            │                   │   ├── error
            │                   │   │   ├── ErrorResponse.java
            │                   │   │   ├── GlobalErrorCode.java
            │                   │   │   ├── GlobalExceptionHandler.java
            │                   │   │   └── filter
            │                   │   │       └── GlobalErrorFilter.java
            │                   │   ├── exception
            │                   │   │   └── InternalServerErrorException.java
            │                   │   ├── property
            │                   │   │   ├── AuthProperties.java
            │                   │   │   ├── AwsS3Properties.java
            │                   │   │   ├── AwsSesProperties.java
            │                   │   │   ├── CoolSmsProperties.java
            │                   │   │   ├── JwtProperties.java
            │                   │   │   └── config
            │                   │   │       └── ConfigurationPropertiesConfig.java
            │                   │   ├── querydsl
            │                   │   │   └── QuerydslConfig.java
            │                   │   ├── security
            │                   │   │   ├── SecurityConfig.java
            │                   │   │   ├── SecurityFacadeAdapter.java
            │                   │   │   ├── exception
            │                   │   │   │   ├── InvalidTokenException.java
            │                   │   │   │   ├── InvalidTokenTypeException.java
            │                   │   │   │   └── UserCredentialsNotFoundException.java
            │                   │   │   ├── jwt
            │                   │   │   │   ├── JwtTokenFilter.java
            │                   │   │   │   └── JwtTokenProvider.java
            │                   │   │   └── principle
            │                   │   │       ├── AuthDetails.java
            │                   │   │       └── AuthDetailsService.java
            │                   │   └── util
            │                   │       └── GenerateRandomStringUtilsAdapter.java
            │                   └── infrastructure
            │                       ├── s3
            │                       │   └── AwsS3Adapter.java
            │                       ├── ses
            │                       │   ├── AwsSESAdapter.java
            │                       │   └── AwsSESConfig.java
            │                       └── sms
            │                           └── CoolSmsAdapter.java
            └── resources
                └── application.yml

202 directories, 389 files
```
©generated by [Project Tree Generator](https://woochanleee.github.io/project-tree-generator)
