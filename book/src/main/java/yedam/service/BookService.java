package yedam.service;

import java.util.List;

public interface BookService {

	// 도서 목록 조회
	List<BookVO> selectAllBook(BookVO bookVO);
	
	// 대여현황 조회
	List<BookVO> selectRentStatus(RentVO rentVO);
	
	// 도서상세 조회
	BookVO selectBookByNo(long bookNo);
	
	// 도서 등록
	int insertBook(BookVO bookVO);
	
}