# 1. IntelliJ 단축키 [cN] : 인덱싱
- [c1] ctrl + space : 자동완성
- [c2] ctrl + shift + a : Action 플러그인 검색
  ex) share project on Git.. : 깃허브 공유 가능
- [c3] ctrl + k : git commit 목록 보기 
- [c4] ctrl + shift + k : 깃 푸시 
- [c5] ctrl + alt + s : 

# **2. Git Hub Push시 주의 사항**
 1. idae 디렉터리는 커밋하지 않는다. 
   > 프로젝트 실행지 자동으로 생성되는 파일들이기 때문에 깃허브에는 불필요<br>
   > git ignore에 추가 해야할 항목 

 
 
# **3. 문서별 설명 정리** 
1. Starting SpringBoot with IntelliJ
    1) Documents 
        - build.gradle
        - .gitignore
    2) 개념 
        - Git 사용방법
            - push
            - gitignore
        - build.gradle
            - dependencies 작성방법
        - intelliJ 사용방법
            - command
            - plugins
2. TestCode
    1) 개념
         - TDD
         - UNIT TEST
         - MOCK...
    9) Documents
        - packages
            1. main.java.com.wancs.prj.springboot
            2. main.java.com.wancs.prj.springboot.web
            3. test.java.com.wancs.prj.springboot.web
        - java
            1. HellController.java
            2. Application.java
            3. HelloControllerTest.java
         - Description
            1. HelloController.md
            2. Application.md
            3. TDDandUnitTest.md
            4. Lombok.md 
         
     
3 JPA 
   3.1) 개념  : JPA 라는 자바표준 ORM(Object Relational Mapping)을 통해 객체 지향 프로그래밍을 할 수 있음.  
            * Mybatis와 iBatis는 SQLMapper임.
   3.2) 의존성 추가 : build.gradle참조, domain.posts 폴더 참조
   3.3) JPA 테스트 코드 작성 
        - PostRepositoryTest
        - application.properties
   3.4) 등록/수정/조회 API 만들기
        - Request 뎅터를 받을 DTO
        - API요청을 받을 Controller
        - 트랜잭션, 도메인 기능 간의 순서를 보장하는 Service
          ㄴ 비즈니스 로직 처리? x => 트랜잭션, 도메인 간 순서보장의 역할 만.. 
          
          <1> WEB Layer         |
          --------------------- | <4> DTOs
          <2> Service Layer     |------------
          --------------------- | <5> Domain
          <3> Repository Layer  |     Model
          
        <1> 컨트롤러(@Controller)와 JSP/Freemaker등의 뷰 템플릿 영역
            필터(@Filter), 인터셉터, @ControllerAdvice 등 외부요청과 응답에 대한 전반적인 영역
        <2> @Service에 사용되는 서비스 영역
            Controller와 Dao의 중간 영역에서 사용
            @Transaction이 사용되어야 하는 영역이기도 함.
        <3> DB와 같이 데이터 저장소에 접근하는 영역
            Dao 영역으로 이해하면 됨. 
        <4> Data Transfer Object - 계층 간에 데이터 교환을 위한 객체.
            뷰 템플렛 엔진에서 사용될 객체나 Repository Layer에서 결과로 넘겨준 객체등
        <5> 도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해할 수 있고 공유할 수 있도록 단순화 시킨것. 
            ex) 택시앱 - 배차/탑승/요금 
            @Entity가 사용된 영역도 포함.
              ㄴ 무조건 DB의 테이블과 관계가 있어야만 하는 것은 아님
              ㄴ VO처럼 값 객체들도 이 영역에 해당도미.
         * 5가지 layers에서 비지니스 처리를 담당하는 곳 ? <5>
         * 트랜잭션 스크립트 : 기존에 서비스로 처리하던 방식
          
        
   3.*) 에러(자세히)콘솔로 띄우는 방법
        공식 문서 
        오타... .is
        api(compile) vs implements 의 차이 
        

## build.gradle 
- 

### git ignore
#### .ignore 플러그인에서 지원하는 기능
 - 파일 위치 자동생성
 - ignore 처리 여부 확인
 - 다양한 ignore 파일 지원(.gitignore, .npmignore, .dockerignore 등등)
 
#### Generator 화면 설명 
 -  기존의 ignore 작성시 추가 가능 

 
## 플러그인 추가 방법 ##
 - [c2] -> plugins -> .ignore (ex).ignore 플러그인 추가
 
#### 생각해볼것. 
 - 본코드와 unit Test의 차이는 ?
  