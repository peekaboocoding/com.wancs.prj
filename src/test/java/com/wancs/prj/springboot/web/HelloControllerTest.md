```java   
package com.wancs.prj.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class) //[1]
@WebMvcTest(controllers = HelloController.class) //[2]
public class HelloControllerTest {

    @Autowired //[3]
    private MockMvc mvc ; //[4]

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //[5]
                .andExpect(status().isOk()) //[6]
                .andExpect(content().string(hello)); //[7]
    }
}
```
---
---
**[1] : @RunWith(SpringRunner.class)**
---
- 테스트를 진행할 때 Junit에 내장된 실행자 외에 다른 실행자를 실행시킴. 
- 여기서는 SpringRunner라는 스프링 실행자를 사용함. 
- 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함. 
<br><br>

**[2] : @WebMvcTest**
---
 - 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
 - 선언할 경우 , @Controller, @ControllerAdvice 등을 사용할 수 있음 
 - 단, @Service, @Component, @Repository등은 사용할 수 없음.
   여기선, 컨트롤러만 사용하기 때문에 선언함. 
<br><br>

**[3] : @Autowired**
---
 - 스프링이 관리하는 빈(Bean)을 주입 받음. 
 
 
<br><br>

**[4] : private MockMvc mvc**
---
 - 엡 api를 테스트할 때 사용
 - 스프링 MVC테스트의 시작점. 
 - 이 클래스를 통해 HTTP GET, POST 등에 대한 API테스트를 할 수 잇음
 <br><br>
 
**[5] : @mvc.perform(get("/hello"))**
---
 - MockMvc를 통해 /hello 주소로 http get 요청을 함. 
 - 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언이 가능 
<br><br>
  
**[6] : .andExpect(status().isOk())**
---
 - mvc.perform의 결과를 검증 
 - HTTP Header의 Status를 검증 
 - 우리가 흔히 알고 있는 200,404,500 등의 상태를 검증
 - 여기선 ok , 200인지 아닌지를 검증 

<br><br>
 
**[7] : .andExpect(content().string(hello))**
---
 - mvc.perform의 결과를 검증합니다.
 - 응답 본문의 내용을 검증합니다. 
 - Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증합니다. 