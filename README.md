# spring_blog

## 1. 환경설정
- security, security-taglibs, mysql, data-jpa 주석처리

## 2. 프로젝트 실행
- testController 
- @Controller : 스프링이 com.kimmjen.blog 패키지 이하를 스캔해서 모든 파일을 메모리에 new 하는 것이 아니라 특정 annotation이 붙어있는 클래스 파일들을 new(IoC:역전의제어)해서 스프링 컨테이너에 관리

## 3. MySQL 한글설정 및 연결

---

1. mysql 한글설정
- my.ini(programData-> mysql*)
- mysql 재시작
```mysql
[client]
default-character-set=utf8

[mysql]
default-character-set=utf8

[mysqld]
collation-server = utf8_unicode_ci
init-connect='SET NAMES utf8'
init_connect='SET collation_connection = utf8_general_ci'
character-set-server=utf8
```

2. 한글 설정 확인

```
show variables like 'c%';
```

3. 사용자 생성 및 권한 주기 및 DB 생성

```
-- 유저이름@아이피주소
create user 'cos'@'%' identified by 'cos1234';
-- ON DB이름.테이블명
-- TO 유저이름@아이피주소
GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
CREATE DATABASE blog CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
use blog;

```

4. mysql 프로젝트 연결

`src/main/resources/application.properties->application.yml`

```
spring:
    datasource:
        driver-class-name: com.mysql.cj.jdbc.Drvier
        url: jdbc:mysql://localhost:3306/blog?serverTimezone=Asia/Seoul
        username: test02
        password: 1111
```

## 4. Http1.1 요청 방식

1. Postman 설치 및 이용

2. Http 1.1
- get
- post
- delete
- put

3. stateless와 stateful

- stateless : server side에 client와 server의 동작, 상태정보를 저장하지 않는 형태, server의 응답이 client와의 세션 상태와 독립적임.
장점: 서버가 client정보를 저장관리 하지 않으므로 Sacling이 자유로움.
- stateful : server side에 client와 server의 동작, 상태정보를 저장하는 형태, 세션 상태에 기반하여 server의 응답이 달라짐.

[stateless vs stateful](https://5equal0.tistory.com/entry/StatefulStateless-Stateful-vs-Stateless-%EC%84%9C%EB%B9%84%EC%8A%A4%EC%99%80-HTTP-%EB%B0%8F-REST)

4. [MIME 타입](https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types)

5. Controller 생성 및 실습
- HttpControllertest 생성
- Get 메서드 : select, 여기서 GetTest(Member m) 방법도 있지만 @RequestParam 사용

- Post 메서드 : insert, 여기서 postTest(String text) , @RequestBody 사용
    
    json { "id":1, "username": "kimmjen"}

- Delete 메서드

- Put 메서드

## 5. Lombok 세팅(Maven)

1. maven

2. lombok
- @Data : 클래스안의 모든 private 필드에 대해 @Getter와 @Setter를 적용하여 세터/게터를 만들어주고 클래스 내에 @ToString 과 @EqualsAndHashCode를 적용하여 메소드를 오버라이드 해주며 @RequiredArgsConstructor를 지정
- @Builder
    - 인자가 많을 경우 쉽고 안전하게 객체를 생성
    - 인자의 순서와 상관없이 객체를 생성
    - 적절한 책임을 이름에 부여하고 가독성 높임
- @AllArgsConstructor : 어노테이션은 모든 필드 값을 파라미터로 받는 생성자를 만들어줌
- @NoArgsConstructor : 어노테이션은 파라미터가 없는 기본 생성자를 생성
- @RequiredArgsConstructor : final 붙은 애들에 대한 constructor 만들어줌, @NonNull 인 필드 값만 파라미터로 받는 생성자
- final 불변성 유지