package com.wancs.prj.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {


}
/*
 - Dao라고 불리는 DBLayer 접근자.
 JPA에선 Repository라고 부르며 인터페이스로 생성.
 단순히 인터페이스를 생성 후 JpaRepository<Entity클래스, PK타입>를 상속하면 기본적인CRUD메소드가 생성됨.

 - <주의사항>
   - Entity클래스와 기본 EntityRepository는 함께 위치해야 함.
   - Annotation 추가 안해도 됨.

 */
