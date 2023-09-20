<<<<<<< HEAD
# PIUM

웹 프로젝트 개발 중입니다.

# Swager Test 주소: http://localhost:9090/swagger-ui.html

## 개발 환경
- 운영체제: Window 10
- IDE: IntelJ
- JDK: JDK 11
- Database : MySql
- Test DB: H2
- 빌드 툴: Gradle
- 관리 툴: 노션, 깃허브

## Dependencies
- Lombok
- Spring Data JPA
- Spring Configuration Processer
- MySql Driver
- Spring Web
- Thymeleaf
- Swager
- validation
- h2database
<<<<<<< HEAD
- security

=======
>>>>>>> origin/CategoryToBoardList+Like+CommentList+Category

=======
# 매칭 작성
### 매칭 작성 기능은 은지누나가 작성함.<br>
# 수정 사항
#### @RestController >> @Controller 에 따른 반환 값 변경<br>thymeleaf 이용해서 값을 받아 입출력하는 테스트 페이지 작성<br>매칭 신청 받은 리스트 기능, 테스트페이지 작성<br>트레이너가 매칭 확정 및 취소 및 삭제 할 수 있는 버튼 생성<br>매칭 확정 버튼 누르면 participate 값이 true(1)로 변경 후 확정 취소 버튼으로 변경<br>매칭 취소 버튼 누르면 particiapte 값이 false(0)로 변경 후 다시 매칭 확정 버튼으로 변경<br>thymeleaf 이용해서 작성.<br>participate 값이 0일 때 매칭 버튼 활성화<br>participate 값이 1일때 취소 버튼 활성화<br>

# 미해결
### 매칭 마감
#### 아이디어<br>1. board 엔티티에 deadline 필드 하나 추가하고 html에 마감버튼을 생성해 연결하고, 해당 게시글에 대한 매칭을 마감시켰을 때, 매칭 신청 폼의 매칭 신청 버튼 비활성화<br>2. html에 마감버튼을 생성해 연결하고, 버튼을 누르면 게시글 상태 변경을 통해 삭제처리를 해서, 물리적으로 신청을 불가능하게 만들기 ( 진석쌤 의견 )
>>>>>>> origin/matchingBoardNewNew

