# yapaghetti

## Project Structure
```
📦 yapaghetti
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
│     │                 │  ├─ Port.java
│     │                 │  └─ UseCase.java
│     │                 ├─ domain
│     │                 │  ├─ company
│     │                 │  ├─ document
│     │                 │  ├─ feedback
│     │                 │  ├─ my_skill
│     │                 │  ├─ student
│     │                 │  ├─ tag
│     │                 │  ├─ teacher
│     │                 │  └─ user
│     │                 │     ├─ api
│     │                 │     │  ├─ SignInPort.java
│     │                 │     │  └─ dto
│     │                 │     │     ├─ request
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
│                          └─ user
│                             └─ usecase
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
         │              │  ├─ feedback
         │              │  ├─ my_skill
         │              │  ├─ student
         │              │  ├─ tag
         │              │  ├─ teacher
         │              │  └─ user
         │              │     ├─ mapper
         │              │     │  └─ UserMapper.java
         │              │     ├─ persistence
         │              │     │  ├─ UserPersistenceAdapter.java
         │              │     │  ├─ UserRepository.java
         │              │     │  └─ entity
         │              │     │     └─ UserEntity.java
         │              │     └─ presentation
         │              │        ├─ UserWebAdapter.java
         │              │        └─ dto
         │              │           └─ request
         │              │              └─ WebSignInRequest.java
         │              ├─ global
         │              │  ├─ annotation
         │              │  │  ├─ Adapter.java
         │              │  │  └─ config
         │              │  │     └─ GlobalComponentScan.java
         │              │  ├─ config
         │              │  │  ├─ FilterConfig.java
         │              │  │  └─ SecurityConfig.java
         │              │  ├─ entity
         │              │  │  └─ BaseIDEntity.java
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
         │              │  └─ security
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
