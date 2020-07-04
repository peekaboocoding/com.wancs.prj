package com.wancs.prj.springboot.domain.posts;

import com.wancs.prj.springboot.web.dto.PostsResponseDto;
import com.wancs.prj.springboot.web.dto.PostsSaveRequestDto;
import com.wancs.prj.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//[1]
@RequiredArgsConstructor
@Service
public class PostsService {
    
    private final PostsRepository postsRepository;
    
    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        return postsRepository.save(requestDto.toEntity()).getId();

    }

    //[2]
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    @Transactional
    public PostsResponseDto findById (Long id)
    {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));

        return new PostsResponseDto(entity);
    }
    
}
/* [1]
 스프링에서 Bean을 주입받는 방식이 3가지
 (1) @Autowired (2) setter (3) 생성자

 - 생성자로 Bean 객체를 받도록 하면 @Autowired와 동일한 효과를 볼 수 있다.
 여기에서는 @RequiredArgsConstructor 가 해결해줌.
 final이 선언된 모든 필드를 인자값으로 하는 생성자를 롬복의  @RequiredArgsConstructor가 대신
 생성해줌.

 생정자를 직접 안쓰고 롬복어노테이션을 사용한 이유?
 해당 클래스의 의존성관계가 변경될 때마다 생성자 코드를 계쏙해서 수정해줘야 하는 번거로움을 해결하기 위함.

 */

/* [2]
* update 기능에서 DB에 쿼리를 날리는 부분이 없는 데,,,
* => JPA의 영속성 컨텍스트 때문.
* */
/** 영속성 컨텍스트?
 *  엔티티를 여구 저장하는 환경.
 *  일종의 논리적 개념,
 *  JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있느냐 없느냐로 갈림...
 *
 *  JPA의 엔티티 메니저가 활성화 된 상태로
 *    트랜잭션 안에서 DB에 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태임.
 *    이 상태에서, 해당 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영.
 *    즉, Entity 객체의 값만 변경하면 별도로 Update 쿼리를 날릴 필요가 없다는 것.
 *    이 개념을 더티체킹이라고 함.
 * */
