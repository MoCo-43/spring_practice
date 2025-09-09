package yedam.service;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {

  private Long bookNo;
  private String bookName;
  private String bookCoverimg;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private String bookDate;
  private String bookPrice; 
  private String bookPublisher;
  private String bookInfo;
}
