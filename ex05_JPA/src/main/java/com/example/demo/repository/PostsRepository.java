package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Posts;
import com.example.demo.dto.PostsListResponseDto;

@Repository
//													<테이블, 기본키 타입>
public interface PostsRepository extends JpaRepository<Posts, Long>{

	@Query("SELECT p FROM Posts p ORDER BY p.id DESC")
	List<Posts> findAllDesc();

	@Query("SELECT p FROM Posts p ")
	Page<PostsListResponseDto> findAllPage(Pageable pageable);
}
