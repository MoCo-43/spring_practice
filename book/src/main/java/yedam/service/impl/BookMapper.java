package yedam.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yedam.service.BookVO;
import yedam.service.RentVO;

@Mapper
public interface BookMapper {

	// 도서 목록 조회
	public List<BookVO> selectAllBook(BookVO bookVO);
	
	// 대여현황 조회
	public List<BookVO> selectRentStatus(RentVO rentVO);
	
	// 도서상세 조회
	public BookVO selectBookByNo(long bookNo);
	
	// 도서 등록
	public int insertBook(BookVO bookVO);
}