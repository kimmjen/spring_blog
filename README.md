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

## 6. yaml 설정

1. [yaml](https://www.inflearn.com/questions/16184) 이란


2. yml 설정( web.xml, root-context.xml, servlet-context.xml의 합본) : application.yml

```
스프링 기본경로
// 스프링 파일 기본 경로 : src/main/resources/static
// 리턴 명을 : /home.html "/" 슬러쉬 를 붙여야함
// 풀경로 : src/main/resources/static/home.html

현재 설정값
springmvc : 
// preifx : /WEB-INF/views/
// suffix : .jsp
// 풀네임 : /WEB-INF/views/test.jsp

```


```
server:
  port: 8000
  servlet:
    context-path: /blog
    encoding:
      charset: UTF-8
      enabled: true
      force: true
    
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
      
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/blog?serverTimezone=Asia/Seoul
    username: cos
    password: cos1234
    
  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: create
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
      use-new-id-generator-mappings: false
    show-sql: true
    properties:
      hibernate.format_sql: true

  jackson:
    serialization:
      fail-on-empty-beans: false
```

(1) jasper
: .jsp 경로를 설정한 이유는 스프링 부트는 기본적으로 jsp 사용이 권장하지 않기 때문에 timeleaf 같은 다른 템플릿 엔진을 사용해야 한다. 하지만 .jsp를 사용하기 위해서는 해당 구조로 폴더 구성을 한 뒤 세팅해야한다.

(2) com.mysql.cj.jdbc.Driver
: datasource의 mysql 드라이버에 cj가 들어간 이유는 mysql 6점대 이상 버전부터는 해당 드라이버를 사용하고 그 이전 드라이버는 js가 없는 com.mysql.jdbc.Driver를 사용

(3) open-in-view

```
org.springframework.orm.hibernate3.support.OpenSessionInViewFilter 클래스
```
: 영속성을 프리젠테이션 계층까지 가져간다. 트랜잭션은 Service계층에서 종료된다. Transaction이 종료된 후에도 Controller의 Session이 close되지 않았기 때문에, 영속 객체는 Persistence 상태를 유지할 수 있으며, 따라서 프록시 객체에 대한 Lazy Loading을 수행할 수 있게 된다.
버전 2.0부터 스프링 부트는 기본적으로 OSIV가 활성화 되었을 때 경고를 발행하므로 프로덕션 시스템에 영향을 주기 전에 문제를 발견 할 수 있다.

![1](a1.png)

서블릿 필터에서 Session을 오픈하고 트랜잭션을 시작하던 전통적인 방식의 Open Session in View 패턴과 달리 SpringMVC에서 제공하는 OpenSessionInViewFilter는 필터 내에서 Session은 오픈하지만 트랜잭션은 시작하지 않는다. 따라서 서블릿 필터 안에서는 커넥션 풀로부터 JDBC커넥션을 얻을 필요가 없다.

```
hibernate.enable_lazy_load_no_trans: true  
```

OSIV를 활성화 하였다면 위에 옵션은 필요 없다. 그리고 OSIV는 스프링 부트가 디폴트로 활성화 하고 있는 옵션이다. 경고를 제거하기 위해 명화갛게 적어준 것.

![2](a2.png)

(3) ddl-auto
- create : 서버 시작시마다 DB초기화
- update : 수정사항만 DB에 반영
- none - DB에 아무런 반영을 하지 않음

(5) Physical-strategy
- org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
- 엔티티를 만들 때 변수명 그대로 DB에 필드를 만들어 준다.
- org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy
- 엔티티를 만들 때 변수명에 언더스코어를 붙여준다. ex) createDate -> create_date

(6) show-sql : true

![3](a3.png)

(7) use-new-id-generator-mappings: false

: use-new-id-generator-mappings 는 mysql로 말하면 auto_increment 오라클로 말하면 시퀀스를 어떤식으로 사용할지 방식을 결정하는 것인데 false를 하면 jpa가 사용하는 기본 넘버링 전략을 따라가지 않는다는 뜻이고 true를 하면 기본 넘버링 전략을 따라간다는 뜻

(8) jackson: serialization: fail-on-empty-beans : false

: Lazy-loading으로 인해 empty-beans이 생길 수 있다. 너그럽게 빈 객체를 허락해주는 옵션이다.