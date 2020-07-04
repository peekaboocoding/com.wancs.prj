package com.wancs.prj.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //[1]
    public void clean_up(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() //[2]
                .title(title)
                .content(content)
                .author("wancs@gamil.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

    }

    /** [1]After
     * - Junit에서 단위 테스트가 끝날때마다 수행되는 메소드를 지정.
     * - 보통 배포전 전체테스트를 수행할 때 테스트간 데이터 침범을 막기위해 사용
     * - 여러 테스트가 동시에 수행되면 테스트용 DB인 H2에 data가 그대로 남아 있어 다음 테스트 실행시 테스트 실패할 수 있음.
     */

    /**[2]postsRepository.save
     * - 테이블 posts에 insert/update 쿼리 실행
     * - id 값이 있다면 update, 없다면 insert 진행
     * */

    // 쿼리로그를 확인하는 방법은 ? application.properties 파일 생성하여 확인 가능 .

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2020,7,1,0,0,0);
        postsRepository.save(Posts.builder()
        .title("title")
        .content("content")
        .author("author")
                .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>> createDate"+posts.getCreatedDate()+", modigiedDate="+posts.getModifiedDate());
        assertThat(posts.getCreatedDate().isAfter(now));
        assertThat(posts.getModifiedDate().isAfter(now));
    }
}
