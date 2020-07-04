package com.wancs.prj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 1. 메인 클래스
 * @SpringBootApplication :
 *  - 스프링 부트의 자동 설정, 스프링 Bean읽기와 생성을 모두 자동으로 설정 .
 *  - 특히! @SpringBootApplication이 있는 위치부터 설정을 읽어감.
 *    그래서 프로젝트 최상단에 위치해야만 함.
 */

@EnableJpaAuditing //[1]
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
/**
 * SpringApplication.run :
 * 내장 WAS를 실행.
 * 내장 WAS? 별도로 외부에 was를 두지 않고 app을 실행할 때 내부에서 was를 실행하는 것을 이야기.
 *           => 서버에 톰캣을 설치할 필요가 없게 되고
 *              스프링 부트로 만들어진 Jar 파일(실행 가능한 Java 패키징 파일)로 실행하면 됨.
 * 내장 WAS를 사용하는 이유?
 *           => 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문.
 */
/**
 * [1] : JPA Auditing 어노테이션들을 모두 활성화할 수 있도록,
 */