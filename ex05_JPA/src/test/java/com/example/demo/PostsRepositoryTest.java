package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Posts;
import com.example.demo.repository.PostsRepository;

@SpringBootTest
public class PostsRepositoryTest {

  @Autowired
  PostsRepository postsRepository;
  
  // 모든 테스트 끝난 후에 실행
  // @DeleteAll()은 모두지움
  @AfterAll
  public void cleanup() {
	  postsRepository.deleteAll();
  }
  
  
//  @Transactional
//  @Rollback
  @Test
  public void insert() {
//	  Posts posts = new Posts("", "", "");
	  
	  // @builder 방식
	  Posts posts = Posts.builder().author("홍길동").title("test").content("test하는 중").build();
	  // 등록
	  postsRepository.save(posts);
  }
  
}
