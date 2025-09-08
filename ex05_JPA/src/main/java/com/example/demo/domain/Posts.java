package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity	
public class Posts extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "post_title", length = 100, nullable = false)
	private String title;
	private String content;
	
//	@Transient
	private String author;

	
	@Builder
	// id를 제외한 컬럼만 생성자 생성
	// Setter를 잘 사용 안함. Posts에 필드값을 변경하면 DB에 반영
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public Posts () {

	}
	
	
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
