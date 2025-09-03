package com.example.demo.ex1;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "회원정보")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
  @Schema(description = "회원이름")	
//  @JsonProperty(value = "username")   // VO의 실제필드는 name이나 username으로 받아들임
  private String name;
  
  
//@JsonIgnore
  @Schema(description = "나이")
  private int age;
  @Schema(description = "가입일자")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date wdate;
  
  // 여러값을 배열형태로도 보내기
  private List<String> hobby;
}
