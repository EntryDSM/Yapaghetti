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
│     │                 │  │  ├─ api
│     │                 │  │  │  ├─ UpdateCompanyNamePort.java
│     │                 │  │  │  └─ dto
│     │                 │  │  │     └─ request
│     │                 │  │  │        └─ DomainUpdateCompanyNameRequest.java
│     │                 │  │  ├─ domain
│     │                 │  │  │  └─ Company.java
│     │                 │  │  ├─ error
│     │                 │  │  │  └─ CompanyErrorCode.java
│     │                 │  │  ├─ exception
│     │                 │  │  │  └─ CompanyNotFoundException.java
│     │                 │  │  ├─ spi
│     │                 │  │  │  ├─ CommandCompanyPort.java
│     │                 │  │  │  ├─ CompanySecurityPort.java
│     │                 │  │  │  └─ QueryCompanyPort.java
│     │                 │  │  └─ usecase
│     │                 │  │     └─ UpdateCompanyNameUseCase.java
│     │                 │  ├─ document
│     │                 │  │  ├─ api
│     │                 │  │  │  ├─ CopyPublicDocumentPort.java
│     │                 │  │  │  ├─ CreateLocalDocumentPort.java
│     │                 │  │  │  ├─ DeleteLocalDocumentPort.java
│     │                 │  │  │  ├─ DeletePublicDocumentPort.java
│     │                 │  │  │  ├─ QueryLocalDocumentPort.java
│     │                 │  │  │  ├─ QueryProtectedDocumentUrlPort.java
│     │                 │  │  │  ├─ QueryPublicDocumentPort.java
│     │                 │  │  │  ├─ UpdateLocalDocumentPort.java
│     │                 │  │  │  └─ dto
│     │                 │  │  │     ├─ request
│     │                 │  │  │     │  ├─ DomainCreateLocalDocumentRequest.java
│     │                 │  │  │     │  └─ DomainUpdateLocalDocumentRequest.java
│     │                 │  │  │     └─ response
│     │                 │  │  │        ├─ QueryDocumentResponse.java
│     │                 │  │  │        └─ QueryProtectedDocumentUrlResponse.java
│     │                 │  │  ├─ domain
│     │                 │  │  │  ├─ Document.java
│     │                 │  │  │  └─ DocumentType.java
│     │                 │  │  ├─ error
│     │                 │  │  │  └─ DocumentErrorCode.java
│     │                 │  │  ├─ exception
│     │                 │  │  │  └─ DocumentNotFoundException.java
│     │                 │  │  ├─ spi
│     │                 │  │  │  ├─ CommandDocumentPort.java
│     │                 │  │  │  └─ QueryDocumentPort.java
│     │                 │  │  └─ usecase
│     │                 │  │     ├─ CopyPublicDocumentUseCase.java
│     │                 │  │     ├─ CreateLocalDocumentUseCase.java
│     │                 │  │     ├─ DeleteLocalDocumentUseCase.java
│     │                 │  │     ├─ DeletePublicDocumentUseCase.java
│     │                 │  │     ├─ QueryLocalDocumentUseCase.java
│     │                 │  │     ├─ QueryProtectedDocumentUrlUseCase.java
│     │                 │  │     ├─ QueryPublicDocumentUseCase.java
│     │                 │  │     └─ UpdateLocalDocumentUseCase.java
│     │                 │  ├─ feedback
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
│     │                 │  │  ├─ .gitKeep
│     │                 │  │  ├─ domain
│     │                 │  │  │  └─ MySkill.java
│     │                 │  │  └─ spi
│     │                 │  │     └─ CommandMySkillPort.java
│     │                 │  ├─ student
│     │                 │  │  ├─ .gitKeep
│     │                 │  │  └─ domain
│     │                 │  │     └─ Student.java
│     │                 │  ├─ tag
│     │                 │  │  ├─ api
│     │                 │  │  │  ├─ AddMySkillPort.java
│     │                 │  │  │  ├─ AddTagPort.java
│     │                 │  │  │  ├─ DeleteTagPort.java
│     │                 │  │  │  ├─ GetTagListPort.java
│     │                 │  │  │  └─ dto
│     │                 │  │  │     ├─ request
│     │                 │  │  │     │  ├─ DomainAddMySkillRequest.java
│     │                 │  │  │     │  └─ DomainAddTagRequest.java
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
│     │                 │  │  │  └─ QueryTagPort.java
│     │                 │  │  └─ usecase
│     │                 │  │     ├─ AddMySkillUseCase.java
│     │                 │  │     ├─ AddTagUseCase.java
│     │                 │  │     ├─ DeleteTagUseCase.java
│     │                 │  │     └─ GetTagListUseCase.java
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
│                          ├─ company
│                          │  └─ usecase
│                          │     └─ UpdateCompanyNameUseCaseTest.java
│                          ├─ document
│                          │  └─ usecase
│                          │     ├─ CopyPublicDocumentTest.java
│                          │     ├─ CreateLocalDocumentTest.java
│                          │     ├─ DeleteLocalDocumentUseCaseTest.java
│                          │     ├─ DeletePublicDocumentTest.java
│                          │     ├─ QueryLocalDocumentUseCaseTest.java
│                          │     ├─ QueryProtectedDocumentUrlTest.java
│                          │     ├─ QueryPublicDocumentTest.java
│                          │     └─ UpdateLocalDocumentTest.java
│                          ├─ image
│                          │  └─ usecase
│                          │     └─ UploadImageUseCaseTest.java
│                          ├─ tag
│                          │  └─ usecase
│                          │     ├─ AddMySkillUseCaseTest.java
│                          │     ├─ AddTagUseCaseTest.java
│                          │     ├─ DeleteTagUseCaseTest.java
│                          │     └─ GetTagListUseCaseTest.java
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
         │              │  │  └─ persistence
         │              │  │     ├─ FeedBackPersistenceAdapter.java
         │              │  │     ├─ FeedBackRepository.java
         │              │  │     └─ entity
         │              │  │        ├─ FeedBackEntity.java
         │              │  │        └─ FeedBackEntityId.java
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
         │              │  │  └─ persistence
         │              │  │     ├─ StudentPersistenceAdapter.java
         │              │  │     ├─ StudentRepository.java
         │              │  │     └─ entity
         │              │  │        └─ StudentEntity.java
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
         │              │  │           └─ WebAddTagRequest.java
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
         │                 └─ sms
         └─ resources
            └─ application.yml
```
©generated by [Project Tree Generator](https://woochanleee.github.io/project-tree-generator)
