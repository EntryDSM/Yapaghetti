# yapaghetti

### Project Structure
```
📦 yapaghetti
├─ .codecov.yml
├─ .github
│  ├─ CODEOWNERS
│  ├─ ISSUE_TEMPLATE.md
│  └─ workflows
│     └─ CI.yml
├─ .gitignore
├─ LICENSE
├─ README.md
├─ build.gradle
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ settings.gradle
├─ yapaghetti-application
│  ├─ build.gradle
│  └─ src
│     ├─ main
│     │  └─ java
│     │     └─ kr
│     │        └─ hs
│     │           └─ entrydsm
│     │              └─ yapaghetti
│     │                 ├─ annotation
│     │                 │  ├─ Aggregate.java
│     │                 │  └─ UseCase.java
│     │                 ├─ domain
│     │                 │  ├─ company
│     │                 │  │  ├─ api
│     │                 │  │  │  ├─ QueryStudentListPort.java
│     │                 │  │  │  ├─ UpdateCompanyNamePort.java
│     │                 │  │  │  └─ dto
│     │                 │  │  │     ├─ request
│     │                 │  │  │     │  ├─ DomainQueryStudentListRequest.java
│     │                 │  │  │     │  └─ DomainUpdateCompanyNameRequest.java
│     │                 │  │  │     └─ response
│     │                 │  │  │        ├─ QueryStudentListResponse.java
│     │                 │  │  │        └─ StudentElement.java
│     │                 │  │  ├─ domain
│     │                 │  │  │  └─ Company.java
│     │                 │  │  ├─ error
│     │                 │  │  │  └─ CompanyErrorCode.java
│     │                 │  │  ├─ exception
│     │                 │  │  │  └─ CompanyNotFoundException.java
│     │                 │  │  ├─ spi
│     │                 │  │  │  ├─ CommandCompanyPort.java
│     │                 │  │  │  ├─ CompanyPort.java
│     │                 │  │  │  ├─ CompanyQueryStudentPort.java
│     │                 │  │  │  ├─ CompanySecurityPort.java
│     │                 │  │  │  └─ QueryCompanyPort.java
│     │                 │  │  └─ usecase
│     │                 │  │     ├─ QueryStudentListUseCase.java
│     │                 │  │     └─ UpdateCompanyNameUseCase.java
│     │                 │  ├─ document
│     │                 │  │  ├─ api
│     │                 │  │  │  ├─ CancelStayDocumentPort.java
│     │                 │  │  │  ├─ CopyPublicDocumentPort.java
│     │                 │  │  │  ├─ CreateLocalDocumentPort.java
│     │                 │  │  │  ├─ DeleteLocalDocumentPort.java
│     │                 │  │  │  ├─ DeletePublicDocumentPort.java
│     │                 │  │  │  ├─ QueryLocalDocumentPort.java
│     │                 │  │  │  ├─ QueryProtectedDocumentUrlPort.java
│     │                 │  │  │  ├─ QueryPublicDocumentPort.java
│     │                 │  │  │  ├─ QueryStayDocumentPort.java
│     │                 │  │  │  ├─ RequestLocalDocumentToPublicPort.java
│     │                 │  │  │  ├─ UpdateLocalDocumentPort.java
│     │                 │  │  │  └─ dto
│     │                 │  │  │     ├─ request
│     │                 │  │  │     │  ├─ DomainCreateLocalDocumentRequest.java
│     │                 │  │  │     │  └─ DomainUpdateLocalDocumentRequest.java
│     │                 │  │  │     └─ response
│     │                 │  │  │        ├─ FeedbackElement.java
│     │                 │  │  │        ├─ QueryDocumentResponse.java
│     │                 │  │  │        ├─ QueryProtectedDocumentUrlResponse.java
│     │                 │  │  │        └─ QueryStayDocumentResponse.java
│     │                 │  │  ├─ domain
│     │                 │  │  │  ├─ Document.java
│     │                 │  │  │  └─ DocumentType.java
│     │                 │  │  ├─ error
│     │                 │  │  │  └─ DocumentErrorCode.java
│     │                 │  │  ├─ exception
│     │                 │  │  │  └─ DocumentNotFoundException.java
│     │                 │  │  ├─ spi
│     │                 │  │  │  ├─ CommandDocumentPort.java
│     │                 │  │  │  ├─ DocumentPort.java
│     │                 │  │  │  ├─ DocumentQueryFeedbackPort.java
│     │                 │  │  │  ├─ DocumentQueryUserPort.java
│     │                 │  │  │  ├─ DocumentSecurityPort.java
│     │                 │  │  │  └─ QueryDocumentPort.java
│     │                 │  │  └─ usecase
│     │                 │  │     ├─ CancelStayDocumentUseCase.java
│     │                 │  │     ├─ CopyPublicDocumentUseCase.java
│     │                 │  │     ├─ CreateLocalDocumentUseCase.java
│     │                 │  │     ├─ DeleteLocalDocumentUseCase.java
│     │                 │  │     ├─ DeletePublicDocumentUseCase.java
│     │                 │  │     ├─ QueryLocalDocumentUseCase.java
│     │                 │  │     ├─ QueryProtectedDocumentUrlUseCase.java
│     │                 │  │     ├─ QueryPublicDocumentUseCase.java
│     │                 │  │     ├─ QueryStayDocumentUseCase.java
│     │                 │  │     ├─ RequestLocalDocumentToPublicUseCase.java
│     │                 │  │     └─ UpdateLocalDocumentUseCase.java
│     │                 │  ├─ feedback
│     │                 │  │  ├─ domain
│     │                 │  │  │  └─ Feedback.java
│     │                 │  │  ├─ error
│     │                 │  │  │  └─ FeedbackErrorCode.java
│     │                 │  │  ├─ exception
│     │                 │  │  │  └─ FeedbackNotFoundException.java
│     │                 │  │  └─ spi
│     │                 │  │     ├─ CommandFeedbackPort.java
│     │                 │  │     └─ FeedbackPort.java
│     │                 │  ├─ image
│     │                 │  │  ├─ api
│     │                 │  │  │  ├─ UploadImagePort.java
│     │                 │  │  │  └─ dto
│     │                 │  │  │     └─ response
│     │                 │  │  │        └─ ImageUrlResponse.java
│     │                 │  │  ├─ error
│     │                 │  │  │  └─ ImageErrorCode.java
│     │                 │  │  ├─ exception
│     │                 │  │  │  ├─ ImageExtensionInvalidException.java
│     │                 │  │  │  └─ ImageNotFoundException.java
│     │                 │  │  ├─ spi
│     │                 │  │  │  ├─ UploadS3Port.java
│     │                 │  │  │  └─ type
│     │                 │  │  │     └─ ImageType.java
│     │                 │  │  └─ usecase
│     │                 │  │     └─ UploadImageUseCase.java
│     │                 │  ├─ my_skill
│     │                 │  │  ├─ domain
│     │                 │  │  │  └─ MySkill.java
│     │                 │  │  └─ spi
│     │                 │  │     └─ MySkillPort.java
│     │                 │  ├─ student
│     │                 │  │  ├─ api
│     │                 │  │  │  ├─ QueryMyInfoPort.java
│     │                 │  │  │  ├─ ReflectFeedbackPort.java
│     │                 │  │  │  └─ dto
│     │                 │  │  │     └─ response
│     │                 │  │  │        └─ MyInfoResponse.java
│     │                 │  │  ├─ domain
│     │                 │  │  │  └─ Student.java
│     │                 │  │  ├─ error
│     │                 │  │  │  └─ StudentErrorCode.java
│     │                 │  │  ├─ exception
│     │                 │  │  │  └─ StudentNotFoundException.java
│     │                 │  │  ├─ spi
│     │                 │  │  │  ├─ CommandStudentPort.java
│     │                 │  │  │  ├─ QueryStudentPort.java
│     │                 │  │  │  ├─ StudentPort.java
│     │                 │  │  │  ├─ StudentQueryDocumentPort.java
│     │                 │  │  │  ├─ StudentQueryFeedbackPort.java
│     │                 │  │  │  ├─ StudentQueryMySkillPort.java
│     │                 │  │  │  ├─ StudentQueryTagPort.java
│     │                 │  │  │  ├─ StudentQueryUserPort.java
│     │                 │  │  │  └─ StudentSecurityPort.java
│     │                 │  │  └─ usecase
│     │                 │  │     ├─ QueryMyInfoUseCase.java
│     │                 │  │     └─ ReflectFeedbackUseCase.java
│     │                 │  ├─ tag
│     │                 │  │  ├─ api
│     │                 │  │  │  ├─ AddMySkillPort.java
│     │                 │  │  │  ├─ AddTagPort.java
│     │                 │  │  │  ├─ DeleteTagPort.java
│     │                 │  │  │  ├─ QueryTagListPort.java
│     │                 │  │  │  ├─ SetMajorTagPort.java
│     │                 │  │  │  └─ dto
│     │                 │  │  │     ├─ request
│     │                 │  │  │     │  ├─ DomainAddMySkillRequest.java
│     │                 │  │  │     │  ├─ DomainAddTagRequest.java
│     │                 │  │  │     │  └─ DomainSetMajorTagRequest.java
│     │                 │  │  │     └─ response
│     │                 │  │  │        ├─ TagElement.java
│     │                 │  │  │        └─ TagListResponse.java
│     │                 │  │  ├─ domain
│     │                 │  │  │  ├─ Tag.java
│     │                 │  │  │  └─ TagType.java
│     │                 │  │  ├─ error
│     │                 │  │  │  └─ TagErrorCode.java
│     │                 │  │  ├─ exception
│     │                 │  │  │  ├─ AlreadyExistsTagException.java
│     │                 │  │  │  ├─ TagNotFoundException.java
│     │                 │  │  │  └─ UnableDeleteTagException.java
│     │                 │  │  ├─ spi
│     │                 │  │  │  ├─ CommandTagPort.java
│     │                 │  │  │  ├─ QueryTagPort.java
│     │                 │  │  │  ├─ TagCommandMySkillPort.java
│     │                 │  │  │  ├─ TagPort.java
│     │                 │  │  │  ├─ TagQueryStudentPort.java
│     │                 │  │  │  └─ TagSecurityPort.java
│     │                 │  │  └─ usecase
│     │                 │  │     ├─ AddMySkillUseCase.java
│     │                 │  │     ├─ AddTagUseCase.java
│     │                 │  │     ├─ DeleteTagUseCase.java
│     │                 │  │     ├─ QueryTagListUseCase.java
│     │                 │  │     └─ SetMajorTagUseCase.java
│     │                 │  ├─ teacher
│     │                 │  │  ├─ api
│     │                 │  │  │  ├─ CreateFeedbackPort.java
│     │                 │  │  │  ├─ DeleteCompanyPort.java
│     │                 │  │  │  ├─ DeleteStudentPort.java
│     │                 │  │  │  └─ dto
│     │                 │  │  │     └─ request
│     │                 │  │  │        └─ DomainCreateFeedbackRequest.java
│     │                 │  │  ├─ spi
│     │                 │  │  │  ├─ CommandTeacherPort.java
│     │                 │  │  │  ├─ QueryTeacherPort.java
│     │                 │  │  │  ├─ TeacherCommandCompanyPort.java
│     │                 │  │  │  ├─ TeacherCommandStudentPort.java
│     │                 │  │  │  ├─ TeacherPort.java
│     │                 │  │  │  ├─ TeacherQueryCompanyPort.java
│     │                 │  │  │  ├─ TeacherQueryStudentPort.java
│     │                 │  │  │  └─ TeacherSecurityPort.java
│     │                 │  │  └─ usecase
│     │                 │  │     ├─ CreateFeedbackUseCase.java
│     │                 │  │     ├─ DeleteCompanyUseCase.java
│     │                 │  │     └─ DeleteStudentUseCase.java
│     │                 │  └─ user
│     │                 │     ├─ api
│     │                 │     │  ├─ FirstPasswordUpdatePort.java
│     │                 │     │  ├─ SignInPort.java
│     │                 │     │  ├─ UpdateUserInformationPort.java
│     │                 │     │  └─ dto
│     │                 │     │     ├─ request
│     │                 │     │     │  ├─ DomainFirstPasswordUpdateRequest.java
│     │                 │     │     │  ├─ DomainSignInRequest.java
│     │                 │     │     │  └─ DomainUpdateUserInformationRequest.java
│     │                 │     │     └─ response
│     │                 │     │        └─ SignInResponse.java
│     │                 │     ├─ domain
│     │                 │     │  ├─ User.java
│     │                 │     │  └─ UserRole.java
│     │                 │     ├─ error
│     │                 │     │  └─ UserErrorCode.java
│     │                 │     ├─ exception
│     │                 │     │  ├─ UserInvalidPasswordException.java
│     │                 │     │  ├─ UserInvalidRoleException.java
│     │                 │     │  └─ UserNotFoundException.java
│     │                 │     ├─ spi
│     │                 │     │  ├─ CommandUserPort.java
│     │                 │     │  ├─ QueryUserPort.java
│     │                 │     │  ├─ UserJwtPort.java
│     │                 │     │  ├─ UserPort.java
│     │                 │     │  └─ UserSecurityPort.java
│     │                 │     └─ usecase
│     │                 │        ├─ FirstPasswordUpdateUseCase.java
│     │                 │        ├─ SignInUseCase.java
│     │                 │        └─ UpdateUserInformationUseCase.java
│     │                 └─ error
│     │                    ├─ ErrorProperty.java
│     │                    └─ YapaghettiException.java
│     └─ test
│        └─ java
│           └─ kr
│              └─ hs
│                 └─ entrydsm
│                    └─ yapaghetti
│                       └─ domain
│                          ├─ company
│                          │  └─ usecase
│                          │     ├─ QueryStudentListUseCaseTest.java
│                          │     └─ UpdateCompanyNameUseCaseTest.java
│                          ├─ document
│                          │  └─ usecase
│                          │     ├─ CancelStayDocumentUseCaseTest.java
│                          │     ├─ CopyPublicDocumentTest.java
│                          │     ├─ CreateLocalDocumentTest.java
│                          │     ├─ DeleteLocalDocumentUseCaseTest.java
│                          │     ├─ DeletePublicDocumentTest.java
│                          │     ├─ QueryLocalDocumentUseCaseTest.java
│                          │     ├─ QueryProtectedDocumentUrlTest.java
│                          │     ├─ QueryPublicDocumentTest.java
│                          │     ├─ QueryStayDocumentTest.java
│                          │     ├─ RequestLocalDocumentToPublicUseCaseTest.java
│                          │     └─ UpdateLocalDocumentTest.java
│                          ├─ image
│                          │  └─ usecase
│                          │     └─ UploadImageUseCaseTest.java
│                          ├─ student
│                          │  └─ usecase
│                          │     ├─ GetMyInfoUseCaseTest.java
│                          │     └─ ReflectFeedbackUseCaseTest.java
│                          ├─ tag
│                          │  └─ usecase
│                          │     ├─ AddMySkillUseCaseTest.java
│                          │     ├─ AddTagUseCaseTest.java
│                          │     ├─ DeleteTagUseCaseTest.java
│                          │     ├─ QueryTagListUseCaseTest.java
│                          │     └─ SetMajorTagUseCaseTest.java
│                          ├─ teacher
│                          │  └─ usecase
│                          │     ├─ CreateFeedbackTest.java
│                          │     ├─ DeleteCompanyTest.java
│                          │     └─ DeleteStudentTest.java
│                          └─ user
│                             └─ usecase
│                                ├─ FirstPasswordUpdateUseCaseTest.java
│                                ├─ SignInUseCaseTest.java
│                                └─ UpdateUserInformationUseCaseTest.java
└─ yapaghetti-infrastructure
   ├─ build.gradle
   └─ src
      └─ main
         ├─ java
         │  └─ kr
         │     └─ hs
         │        └─ entrydsm
         │           └─ yapaghetti
         │              ├─ YapaghettiApplication.java
         │              ├─ domain
         │              │  ├─ company
         │              │  │  ├─ mapper
         │              │  │  │  └─ CompanyMapper.java
         │              │  │  ├─ persistence
         │              │  │  │  ├─ CompanyPersistenceAdapter.java
         │              │  │  │  ├─ CompanyRepository.java
         │              │  │  │  └─ entity
         │              │  │  │     └─ CompanyEntity.java
         │              │  │  └─ presentation
         │              │  │     ├─ CompanyWebAdapter.java
         │              │  │     └─ dto
         │              │  │        └─ request
         │              │  │           └─ WebUpdateCompanyNameRequest.java
         │              │  ├─ document
         │              │  │  ├─ mapper
         │              │  │  │  └─ DocumentMapper.java
         │              │  │  ├─ persistence
         │              │  │  │  ├─ DocumentPersistenceAdapter.java
         │              │  │  │  ├─ DocumentRepository.java
         │              │  │  │  └─ entity
         │              │  │  │     └─ DocumentEntity.java
         │              │  │  └─ presentation
         │              │  │     ├─ DocumentWebAdapter.java
         │              │  │     └─ dto
         │              │  │        └─ request
         │              │  │           └─ WebLocalDocumentRequest.java
         │              │  ├─ feedback
         │              │  │  ├─ mapper
         │              │  │  │  └─ FeedbackMapper.java
         │              │  │  └─ persistence
         │              │  │     ├─ FeedbackPersistenceAdapter.java
         │              │  │     ├─ FeedbackRepository.java
         │              │  │     └─ entity
         │              │  │        ├─ FeedbackEntity.java
         │              │  │        └─ FeedbackEntityId.java
         │              │  ├─ image
         │              │  │  └─ presentation
         │              │  │     └─ ImageWebAdapter.java
         │              │  ├─ my_skill
         │              │  │  ├─ mapper
         │              │  │  │  └─ MySkillMapper.java
         │              │  │  └─ persistence
         │              │  │     ├─ MySkillPersistenceAdapter.java
         │              │  │     ├─ MySkillRepository.java
         │              │  │     └─ entity
         │              │  │        ├─ MySkillEntity.java
         │              │  │        └─ MySkillEntityId.java
         │              │  ├─ student
         │              │  │  ├─ mapper
         │              │  │  │  └─ StudentMapper.java
         │              │  │  ├─ persistence
         │              │  │  │  ├─ StudentPersistenceAdapter.java
         │              │  │  │  ├─ StudentRepository.java
         │              │  │  │  └─ entity
         │              │  │  │     └─ StudentEntity.java
         │              │  │  └─ presentation
         │              │  │     └─ StudentWebAdapter.java
         │              │  ├─ tag
         │              │  │  ├─ mapper
         │              │  │  │  └─ TagMapper.java
         │              │  │  ├─ persistence
         │              │  │  │  ├─ TagPersistenceAdapter.java
         │              │  │  │  ├─ TagRepository.java
         │              │  │  │  └─ entity
         │              │  │  │     └─ TagEntity.java
         │              │  │  └─ presentation
         │              │  │     ├─ TagWebAdapter.java
         │              │  │     └─ dto
         │              │  │        └─ request
         │              │  │           ├─ WebAddMySkillRequest.java
         │              │  │           ├─ WebAddTagRequest.java
         │              │  │           └─ WebSetMajorTagRequest.java
         │              │  ├─ teacher
         │              │  │  ├─ persistence
         │              │  │  │  ├─ TeacherPersistenceAdapter.java
         │              │  │  │  ├─ TeacherRepository.java
         │              │  │  │  └─ entity
         │              │  │  │     └─ TeacherEntity.java
         │              │  │  └─ presentation
         │              │  │     ├─ TeacherWebAdapter.java
         │              │  │     └─ dto
         │              │  │        └─ request
         │              │  │           └─ WebCreateFeedbackRequest.java
         │              │  └─ user
         │              │     ├─ mapper
         │              │     │  └─ UserMapper.java
         │              │     ├─ persistence
         │              │     │  ├─ UserPersistenceAdapter.java
         │              │     │  ├─ UserQuerydslExtension.java
         │              │     │  ├─ UserQuerydslImpl.java
         │              │     │  ├─ UserRepository.java
         │              │     │  └─ entity
         │              │     │     └─ UserEntity.java
         │              │     └─ presentation
         │              │        ├─ UserWebAdapter.java
         │              │        └─ dto
         │              │           └─ request
         │              │              ├─ WebFirstPasswordUpdateRequest.java
         │              │              ├─ WebSignInRequest.java
         │              │              └─ WebUpdateUserInformationRequest.java
         │              ├─ global
         │              │  ├─ annotation
         │              │  │  ├─ Adapter.java
         │              │  │  └─ config
         │              │  │     └─ GlobalComponentScan.java
         │              │  ├─ config
         │              │  │  └─ FilterConfig.java
         │              │  ├─ entity
         │              │  │  └─ BaseUUIDEntity.java
         │              │  ├─ error
         │              │  │  ├─ ErrorResponse.java
         │              │  │  ├─ GlobalErrorCode.java
         │              │  │  ├─ GlobalExceptionHandler.java
         │              │  │  └─ filter
         │              │  │     └─ GlobalErrorFilter.java
         │              │  ├─ exception
         │              │  │  └─ InternalServerErrorException.java
         │              │  ├─ property
         │              │  │  ├─ AwsS3Properties.java
         │              │  │  ├─ AwsSesProperties.java
         │              │  │  ├─ JwtProperties.java
         │              │  │  └─ config
         │              │  │     └─ ConfigurationPropertiesConfig.java
         │              │  ├─ querydsl
         │              │  │  └─ QuerydslConfig.java
         │              │  └─ security
         │              │     ├─ SecurityConfig.java
         │              │     ├─ SecurityFacadeAdapter.java
         │              │     ├─ exception
         │              │     │  ├─ InvalidTokenException.java
         │              │     │  ├─ InvalidTokenTypeException.java
         │              │     │  └─ UserCredentialsNotFoundException.java
         │              │     ├─ jwt
         │              │     │  ├─ JwtTokenFilter.java
         │              │     │  └─ JwtTokenProvider.java
         │              │     └─ principle
         │              │        ├─ AuthDetails.java
         │              │        └─ AuthDetailsService.java
         │              └─ infrastructure
         │                 ├─ s3
         │                 │  └─ AwsS3Adapter.java
         │                 ├─ ses
         │                 │  └─ .gitKeep
         │                 └─ sms
         │                    └─ .gitKeep
         └─ resources
            └─ application.yml
```
©generated by [Project Tree Generator](https://woochanleee.github.io/project-tree-generator)
