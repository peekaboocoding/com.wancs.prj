package com.wancs.prj.springboot.domain.posts;
/***
 *  Entity를 지정하는 역할
 *  Setter대신 @Builder를 사용함.
 *  기본적인 구조는 생성자를 사용하여 값을 넣는 것이지만,
 *  생성자는 매개변수의 순서가 변경되어도 오류를 찾을 수 없음.
 *  하지만, 빌더를 사용하면 어떤 필드에 어떤 값을 넣는지가 명확해짐.
 *
 *  기본적으로 getter/setter를 많이 사용하지만,
 *  이러한 경우 해당 클래스의 인스턴스가 언제 어디서 변하는지 명확하게 구분하는게 어려워짐
 *  => Builder를 사용하고, 만약 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도가 나타나는
 *  메소드를 추가해야 함.
 */

import com.wancs.prj.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


// 필수 어노테이션일수록 클래스에 가까이... why? 언어 전환시 유용
@Getter //Getter메소드 자동 생성..
@NoArgsConstructor //기본생성자 자동추가. public Posts(){}와 같은 효과
@Entity // 테이블과 링크될 클래스, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭.
public class Posts extends BaseTimeEntity {//Entity Class 라고 말함.

    @Id // PK 필드
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // Spring boot 2.0에서의 차이... GenerationType.I...
    private Long id;

    @Column(length = 500, nullable = false) //@Column은 default 임, 추가 변경이 필요한 옵션시... 선언
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder // 빌더패턴클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 6.29
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
/*
* @Entity
*  - 테이블과 링크될 클래스임을 나타냄
*  - 기본값으로 클래스의 카멜케이스 -> _ (언더스코어 네이밍)으로 테이블 이름 매칭
* */