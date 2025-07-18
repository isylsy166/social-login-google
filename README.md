# social-login-google
Spring Boot와 Google OAuth2를 활용한 구글 소셜 로그인 구현 실습 프로젝트입니다.
개발 및 테스트용 MySQL은 Docker로 구성되어 있습니다.

---

## 프로젝트 구조
```yaml
src
└── main
    ├── java
    │   └── com.example.sociallogin
    │       ├── SocialLoginGoogleApplication.java # Spring Boot 메인 실행 클래스
    │       │
    │       ├── config                        
    │       │   ├── SecurityConfig.java            # Spring Security 설정(OAuth로그인 & 필터) 
    │       │   └── JwtAuthenticationFilter.java   # 요청이 오면 토큰 검증해주는 필터
    │       │
    │       ├── jwt                        
    │       │   └── JwtTokenProvider.java          # JWT 생성, 파싱, 검증
    │       │
    │       ├── oauth       
    │       │   ├── CustomOAuth2User # 구글에서 받은 사용자 정보를 담는 클래스
    │       │   ├── CustomOAuth2UserService.java # 구글에서 받은 사용자 정보로 유저 생성/조회 처리
    │       │   └── OAuth2SuccessHandler.java # 로그인 성공 시 JWT 발급 후 응답처리
    │       │
    │       ├── domain               
    │       │   ├── User.java                 # 유저 테이블 매핑
    │       │   └── UserRepository.java       # 유저를 DBdptj 조회/저장할 때 사용하는 인터페이스
    │       │
    │       ├── controller                    
    │       │   └── UserController.java       # 테스트용 API
    │       │
    │       ├── dto                           # 응답/요청 DTO
    │       │   └── UserResponseDto.java
    │       │
    │       └── service
    │           └── UserService.java
    │
    └── resources
        └── application.properties # DB 정보, JWT 시크릿 등 설정값 관리
```

## 🛠 기술 스택
* Spring Boot
* Spring Security
* OAuth2 Client (Google Login)
* Spring Data JPA
* MySQL (Docker Compose)
* Lombok

---
## 🚀 실행 방법
1️⃣ MySQL 컨테이너 실행 (Docker)

    docker compose up -d

📦 컨테이너 확인:

    docker ps

MySQL은 다음 설정으로 구성되어 있습니다:

| Key      | Value             |
| -------- | ----------------- |
| Host     | `localhost:3306`  |
| DB Name  | `google_login_db` |
| Username | `soyeon`          |
| Password | `testmysql`       |

---

## 🔐 Google OAuth2 Redirect URL

http://localhost:8081/oauth2/authorization/google

로그인 시도 시 위 주소로 접속하면 Google 로그인 페이지로 리다이렉트됩니다.

✅ 조건:
* 백엔드 서버가 실행 중이어야 합니다.