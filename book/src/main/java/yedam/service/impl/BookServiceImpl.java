package yedam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import yedam.service.BookService;
import yedam.service.BookVO;
import yedam.service.RentVO;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

	@Autowired
	BookMapper bookMapper;

	// 도서 목록 조회
	@Override
	public List<BookVO> selectAllBook(BookVO bookVO) {
		return bookMapper.selectAllBook(bookVO);
	}

	// 대여현황 조회
	@Override
	public List<BookVO> selectRentStatus(RentVO rentVO) {
		return bookMapper.selectRentStatus(rentVO);
	}

	// 도서상세 조회
	@Override
	public BookVO selectBookByNo(long bookNo) {
		return bookMapper.selectBookByNo(bookNo);
	}

	// 도서 등록
	@Override
	public int insertBook(BookVO bookVO) {
		return bookMapper.insertBook(bookVO);
	}


	

}
