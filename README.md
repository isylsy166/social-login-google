# social-login-google
Spring Boot와 Google OAuth2를 활용한 구글 소셜 로그인 구현 실습 프로젝트입니다.
개발 및 테스트용 MySQL은 Docker로 구성되어 있습니다.

---

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