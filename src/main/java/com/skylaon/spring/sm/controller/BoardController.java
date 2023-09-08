package com.skylaon.spring.sm.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skylaon.spring.sm.service.Alert;
import com.skylaon.spring.sm.service.BoardService;
import com.skylaon.spring.sm.vo.BoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*")	//프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.  
@AllArgsConstructor	//필드 값을 매개변수로 하는 생성자를 스프링이 알아서 만들어 줌. 그리고 그런 형태의 생성자를 추가하면 스프링이 알아서 객체관리 해줌(@Auto.. 처럼)
@Controller
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/category")
	public void category() {
		
	}
	
	@GetMapping("/getList")	// 프로젝트 루트 경로 이하 /guest/getList url 진입 시 여기로 진입하게 됨.
	public void getList(/*@RequestParam(value = "currentPage", defaultValue = "1")int currentPage,*/
						@RequestParam("category") String category , Model model) {	// 매개변수에 Model m 식으로 작성하게 되면, 스프링이 알아서 모델 객체를 만들어서 넘겨줌.
		log.info("컨트롤러에서 호출");
		//model.addAttribute("blp",service.List(currentPage));
		model.addAttribute("category", category);
		model.addAttribute("list",service.getList(category));
	}	
	
	@GetMapping({"/read", "/modify"})
	public void read(@RequestParam("no") int bno,@RequestParam("category") String category, Model model) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		model.addAttribute("category", category);
		model.addAttribute("read",service.read(bno));
	}
	
	@GetMapping("/del")
	public void del(HttpServletResponse response, @RequestParam("no") int no, @RequestParam("category") String category) {
		service.del(no);
		Alert.alertAndGo(response, "게시물이 삭제되었습니다", "/board/getList?category=" + category);
	}
	
	
	@PostMapping("/write")
	public void write(HttpServletResponse response, BoardVO gvo, @RequestParam("b_category") String category) {
		service.write(gvo);
		Alert.alertAndGo(response, "게시물이 등록되었습니다.", "/board/getList?category=" + category);
	}
	
	@GetMapping("/write")	// 책 p.239 /write 중복이지만 이건 글쓰기 화면을 위한 url 매핑
	public void write() {
	}
	
	@PostMapping("/modify")
	public void modify(HttpServletResponse response, BoardVO gvo, @RequestParam("b_category") String category) {
		service.modify(gvo);
		Alert.alertAndGo(response, "게시물이 수정되었습니다.", "/board/getList?category=" + category);
	}
	
}

