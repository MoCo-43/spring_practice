package yedam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import yedam.service.BookService;
import yedam.service.BookVO;
import yedam.service.RentVO;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	// 메인화면
	@GetMapping("/")
	public String mainPage() {
		return "index";
	}
	
	// 도서 목록 조회
	@GetMapping("bookList")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public String bookList(Model model, BookVO bookVO) {
	  model.addAttribute("list", bookService.selectAllBook(bookVO));
		return "list";
	}
	
	// 도서상세 조회
	@GetMapping("bookList/{bookNo}")
	public String bookListDetail(Model model, @PathVariable Long bookNo) {
	  model.addAttribute("detail", bookService.selectBookByNo(bookNo));
	  return "list_detail";
	}
	
	// 대여현황 조회
	@GetMapping("rent")
	public String bookListByNo(Model model, RentVO rentVO) {
	  model.addAttribute("rent", bookService.selectRentStatus(rentVO));
	  return "list_detail";
	}
	
	// 도서 등록페이지 이동
	@GetMapping("register")
	public String registerPage (BookVO bookVO) {
	  return "register";
	}
	

	// 도서 등록
	@PostMapping("register")
	public String bookRegister (BookVO bookVO) {
	  bookService.insertBook(bookVO);
	  return "register";
	}
	
}
