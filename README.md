# yapaghetti

## Project Structure
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
│     │                 │  │  └─ .gitKeep
│     │                 │  ├─ document
│     │                 │  │  ├─ api
│     │                 │  │  │  ├─ CreateLocalDocumentPort.java
│     │                 │  │  │  └─ dto
│     │                 │  │  │     └─ request
│     │                 │  │  │        └─ DomainCreateLocalDocumentRequest.java
│     │                 │  │  ├─ domain
│     │                 │  │  │  ├─ Document.java
│     │                 │  │  │  └─ DocumentType.java
│     │                 │  │  ├─ error
│     │                 │  │  ├─ exception
│     │                 │  │  ├─ spi
│     │                 │  │  │  └─ CommandDocumentPort.java
│     │                 │  │  └─ usecase
│     │                 │  │     └─ CreateLocalDocumentUseCase.java
│     │                 │  ├─ feedback
│     │                 │  ├─ my_skill
│     │                 │  ├─ student
│     │                 │  ├─ tag
│     │                 │  │  └─ domain
│     │                 │  │     └─ TagType.java
│     │                 │  ├─ teacher
│     │                 │  └─ user
│     │                 │     ├─ api
│     │                 │     │  ├─ FirstPasswordUpdatePort.java
│     │                 │     │  ├─ SignInPort.java
│     │                 │     │  └─ dto
│     │                 │     │     ├─ request
│     │                 │     │     │  ├─ DomainFirstPasswordUpdateRequest.java
│     │                 │     │     │  └─ DomainSignInRequest.java
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
│     │                 │     │  └─ UserSecurityPort.java
│     │                 │     └─ usecase
│     │                 │        ├─ FirstPasswordUpdateUseCase.java
│     │                 │        └─ SignInUseCase.java
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
│                          ├─ document
│                          │  └─ usecase
│                          │     └─ CreateLocalDocumentTest.java
│                          └─ user
│                             └─ usecase
│                                ├─ FirstPasswordUpdateUseCaseTest.java
│                                └─ SignInUseCaseTest.java
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
         │              │  │  └─ persistence
         │              │  │     ├─ CompanyPersistenceAdapter.java
         │              │  │     ├─ CompanyRepository.java
         │              │  │     └─ entity
         │              │  │        └─ CompanyEntity.java
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
         │              │  │           └─ WebCreateLocalDocumentRequest.java
         │              │  ├─ feedback
         │              │  │  └─ persistence
         │              │  │     ├─ FeedBackPersistenceAdapter.java
         │              │  │     ├─ FeedBackRepository.java
         │              │  │     └─ entity
         │              │  │        ├─ FeedBackEntity.java
         │              │  │        └─ FeedBackEntityId.java
         │              │  ├─ my_skill
         │              │  │  └─ persistence
         │              │  │     ├─ MySkillPersistenceAdapter.java
         │              │  │     ├─ MySkillRepository.java
         │              │  │     └─ entity
         │              │  │        ├─ MySkillEntity.java
         │              │  │        └─ MySkillEntityId.java
         │              │  ├─ student
         │              │  │  ├─ StudentPersistenceAdapter.java
         │              │  │  ├─ StudentRepository.java
         │              │  │  └─ persistence
         │              │  │     └─ entity
         │              │  │        └─ StudentEntity.java
         │              │  ├─ tag
         │              │  │  └─ persistence
         │              │  │     ├─ TagPersistenceAdapter.java
         │              │  │     ├─ TagRepository.java
         │              │  │     └─ entity
         │              │  │        └─ TagEntity.java
         │              │  ├─ teacher
         │              │  │  └─ persistence
         │              │  │     ├─ TeacherPersistenceAdapter.java
         │              │  │     ├─ TeacherRepository.java
         │              │  │     └─ entity
         │              │  │        └─ TeacherEntity.java
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
         │              │              └─ WebSignInRequest.java
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
         │              │  │  ├─ ImageExtensionInvalidException.java
         │              │  │  ├─ ImageNotFoundException.java
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
         │                 │  ├─ AwsS3Adapter.java
         │                 │  └─ type
         │                 │     └─ ImageType.java
         │                 ├─ ses
         │                 └─ sms
         └─ resources
            └─ application.yml
```
©generated by [Project Tree Generator](https://woochanleee.github.io/project-tree-generator)
