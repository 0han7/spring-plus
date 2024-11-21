# 내일배움캠프 스프링 플러스주차 개인 과제 레거시 코드 리팩토링 플러스

## 🖥️프로젝트 소개
레거시 코드를 개선하는 업무 과제입니다.

## 📆개발 기간
* 24.11.19 ~ 24.11.21

### 🖥️기술 스택
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">

## 📌주요 개선

## Level 1
### 1. @Transactional의 이해
* ```할 일 저장 기능을 구현한 API(/todos)```를 호출할 때
에러가 발생하지 않고 정상적으로 할 일을 저장할 수 있게 수정했습니다.

### 2.  JWT의 이해
* User 테이블에 nickname 컬럼을 추가했습니다.
* JWT에서 유저의 닉네임을 확인할 수 있습니다.

### 3.  AOP의 이해
* ```AdminAccessLoggingAspect``` 클래스에 있는 AOP가 개발 의도에 맞도록 코드를 수정했습니다.

### 4. 컨트롤러 테스트의 이해
* ```todo_단건_조회_시_todo가_존재하지_않아_예외가_발생한다()``` 테스트 오류 수정했습니다.

### 5. JPA의 이해
* 할 일 검색 시 ```weather``` 조건으로도 검색할 수 있도록 추가했습니다.
* 할 일 검색 시 ```수정일``` 기준으로 기간 검색이 가능합니다.


## Level 2

###  6. JPA Cascade
* 할 일을 새로 저장할 시, 할 일을 생성한 유저는 담당자로 자동 등록해야 합니다.
* JPA의 ```cascade``` 기능을 활용해 할 일을 생성한 유저가 담당자로 등록될 수 있게 했습니다.

### 7. N+1 문제 발생
* ```Fetch join```을 사용하여 문제를 해결했습니다.

---

## 📌 개선해야할 부분
### 1. @Query를 사용하여 JPA를 작성하는 방법 
* Spring Data JPA @Query 어노테이션를 사용 및 테스트 수행 공부하기


### 2. QueryDSL의 전반적인 지식과 사용 방법
* QueryDSL를 사용하는 이유와 의존성 추가방법 공부하기
* 기본적인 QueryDSL 사용방법 공부하기
### 3. 토큰 기반 인증 방식을 유지한 채로 Spring Security를 도입하기 위한 이해도
* 토큰 방식과 세션 기반 인증에 대한 개념 복습하기
* Spring security JWT 구현 해보기
