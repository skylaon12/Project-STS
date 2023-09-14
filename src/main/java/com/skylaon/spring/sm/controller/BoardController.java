package com.skylaon.spring.sm.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skylaon.spring.sm.board.ConfigBoard;
import com.skylaon.spring.sm.service.Alert;
import com.skylaon.spring.sm.service.BoardService;
import com.skylaon.spring.sm.vo.BoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*") // 프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.
@AllArgsConstructor // 필드 값을 매개변수로 하는 생성자를 스프링이 알아서 만들어 줌. 그리고 그런 형태의 생성자를 추가하면 스프링이 알아서 객체관리
					// 해줌(@Auto.. 처럼)
@Controller
public class BoardController {

	private BoardService service;

	@GetMapping("/category")
	public void category() {

	}

	@GetMapping("/getList")
	public void getList(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam("category") String category, Model model) {

		// 넘어온 페이지 값으로 시작 인덱스 구하기
		int index = service.getStartIndex(page);

		// 전체 글 수 구하기
		int totalCount = service.getTotalCount(category);
		log.info("==== 방명록 - 전체 글 수 : " + totalCount);

		// todo
		// 전체 페이지 수 구하기
		int totalPage = service.getTotalPage(category);
		log.info("==== 방명록 - 전체 페이지 수 : " + totalPage);

		// 블럭 당 페이지 수를 정함
		// PAGE_PER_BLOCK

		// todo
		// 전체 블럭 수 구하기
		// 필요값
		// totalPage
		// 블럭 당 페이지 수 ( PAGE_PER_BLOCK)

		int totalBlock = service.getTotalBlock(totalPage);
		log.info("==== 방명록 - 전체 블럭 수 : " + totalPage);

		// 현재 페이지로 현재 블럭 번호 구하기
		// 총 페이지 블럭페이지값
		int currentBlock = (int) Math.ceil((double) page / ConfigBoard.PAGE_PER_BLOCK);
		log.info("==== 방명록 - 현재 블럭 번호 : " + currentBlock);

		// todo

		// 🐿️🐿️🐿️{블럭 처리 - 3/9}.블럭 시작 페이지 번호 구하기🐿️🐿️🐿️//
		// 블럭 시작 페이지 번호 = (현재 블럭 번호 - 1) * 블럭 당 페이지 수 + 1
		int blockStartNo = (currentBlock - 1) * ConfigBoard.PAGE_PER_BLOCK + 1;
		// 🐿️🐿️🐿️{블럭 처리 - 4/9}.블럭 페이지 끝 번호 구하기🐿️🐿️🐿️//
		// 블럭 페이지 끝 번호 = 현재 블럭 번호 * 블럭 당 페이지 수
		int blockEndNo = currentBlock * ConfigBoard.PAGE_PER_BLOCK;
		if (blockEndNo > totalPage)
			blockEndNo = totalPage;
		log.info("==== 방명록 - 현재 블럭 시작 번호 : " + blockStartNo);
		log.info("==== 방명록 - 현재 블럭 끝 번호 : " + blockEndNo);

		// 🐿️🐿️🐿️{블럭 처리 - 6/9}.(이전/다음) 관련 계산 등 처리🐿️🐿️🐿️
		boolean hasPrev = true; // 이전 블럭 가기 가능 여부 저장값 초기화.
		boolean hasNext = true; // 다음 블럭 가기 가능 여부 저장값 초기화.
		int prevPage = 0;
		int nextPage = 0;

		// 🐿️🐿️🐿️{블럭 처리 - 6/9}.(이전/다음) 관련 계산 등 처리🐿️🐿️🐿️
		// 🐿️🐿️🐿️: 현재 블럭에서 이전/다음이 가능한지 계산하고 가능 여부를 저장해두기🐿️🐿️🐿️//
		if (currentBlock == 1) { // 현재 블럭이 1번 블럭이면
			hasPrev = false; // 이전 블럭 가기 불가능
		} else { // 현재 블럭이 1번 블럭이 아니면
			hasPrev = true; // 이전 블럭 가기 가능
			// 🐿️🐿️🐿️: 이전 블럭 이동 시 몇 페이지로 이동할지 정하기🐿️🐿️🐿️//
			// 이전 블럭의 마지막 페이지로 이동하게 하면 됨(보통 이렇게 처리하니까)
			// 공식 : (현재 블럭 번호 - 1) * 블럭 당 페이지 수
			prevPage = (currentBlock - 1) * ConfigBoard.PAGE_PER_BLOCK;
		}
		if (currentBlock < totalBlock) { // 현재 블럭이 마지막 블럭보다 작으면
			hasNext = true; // 다음 블럭 가기 가능
			// 🐿️🐿️🐿️: 다음 블럭 이동 시 몇 페이지로 이동할지 정하기🐿️🐿️🐿️//
			// 다음 블럭의 첫 페이지로 이동하게 하면 됨(보통 이렇게 처리하니까)
			// 공식 : 현재 블럭 번호 * 블럭 당 페이지 수 + 1
			nextPage = currentBlock * ConfigBoard.PAGE_PER_BLOCK + 1;
		} else { // 현재 블럭이 마지막 블럭보다 같거나 크면(큰값이 오면 안되겠지만)
			hasNext = false; // 다음 블럭 가기 불가능
		}

		// 페이지 리스트 뿌리기
		model.addAttribute("category", category);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalBlock", totalBlock);
		model.addAttribute("currentBlock", currentBlock);
		model.addAttribute("blockStartNo", blockStartNo);
		model.addAttribute("blockEndNo", blockEndNo);
		model.addAttribute("hasPrev", hasPrev);
		model.addAttribute("hasNext", hasNext);
		model.addAttribute("prevPage", prevPage);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("list", service.getList(category, index));
	}

	@GetMapping("/search")
	public void getSearchList(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam("category") String category, @RequestParam("word") String word, Model model) {

		int index = service.getStartIndex(page);
		int totalCount = service.getTotalCount(word, category);
		log.info("==== 방명록 - 전체 글 수 : " + totalCount);
		int totalPage = service.getTotalPage(totalCount, word, category);
		log.info("==== 방명록 - 전체 페이지 수 : " + totalPage);

		int totalBlock = service.getTotalBlock(totalPage);
		log.info("==== 방명록 - 전체 블럭 수 : " + totalPage);

		int currentBlock = (int) Math.ceil((double) page / ConfigBoard.PAGE_PER_BLOCK);
		log.info("==== 방명록 - 현재 블럭 번호 : " + currentBlock);

		int blockStartNo = (currentBlock - 1) * ConfigBoard.PAGE_PER_BLOCK + 1;
		int blockEndNo = currentBlock * ConfigBoard.PAGE_PER_BLOCK;
		if (blockEndNo > totalPage)
			blockEndNo = totalPage;
		log.info("==== 방명록 - 현재 블럭 시작 번호 : " + blockStartNo);
		log.info("==== 방명록 - 현재 블럭 끝 번호 : " + blockEndNo);

		boolean hasPrev = true; // 이전 블럭 가기 가능 여부 저장값 초기화.
		boolean hasNext = true; // 다음 블럭 가기 가능 여부 저장값 초기화.
		int prevPage = 0;
		int nextPage = 0;

		if (currentBlock == 1) { // 현재 블럭이 1번 블럭이면
			hasPrev = false; // 이전 블럭 가기 불가능
		} else { // 현재 블럭이 1번 블럭이 아니면
			hasPrev = true; // 이전 블럭 가기 가능
			prevPage = (currentBlock - 1) * ConfigBoard.PAGE_PER_BLOCK;
		}
		if (currentBlock < totalBlock) { // 현재 블럭이 마지막 블럭보다 작으면
			hasNext = true; // 다음 블럭 가기 가능
			nextPage = currentBlock * ConfigBoard.PAGE_PER_BLOCK + 1;
		} else { // 현재 블럭이 마지막 블럭보다 같거나 크면(큰값이 오면 안되겠지만)
			hasNext = false; // 다음 블럭 가기 불가능
		}

		// 페이지 리스트 뿌리기
		model.addAttribute("category", category);
		model.addAttribute("word", word);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalBlock", totalBlock);
		model.addAttribute("currentBlock", currentBlock);
		model.addAttribute("blockStartNo", blockStartNo);
		model.addAttribute("blockEndNo", blockEndNo);
		model.addAttribute("hasPrev", hasPrev);
		model.addAttribute("hasNext", hasNext);
		model.addAttribute("prevPage", prevPage);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("list", service.getSearchList(word, category, index));
	}
	
	@GetMapping("/read")
	public void read(@RequestParam("no") int bno, @RequestParam("category") String category, Model model) {
		log.info("컨트롤러 ==== 글번호 ===============" + bno);
		model.addAttribute("category", category);
		model.addAttribute("read", service.read(bno));
	}
	
	@GetMapping("/modify")
	public void modify(@RequestParam("no") int bno, @RequestParam("category") String category, Model model) {
		log.info("컨트롤러 ==== 글번호 ===============" + bno);
		model.addAttribute("category", category);
		model.addAttribute("read", service.read(bno));
	}

	@GetMapping("/del")
	public void del(HttpServletResponse response, @RequestParam("no") int no,
			@RequestParam("category") String category) {
		service.del(no);
		Alert.alertAndGo(response, "게시물이 삭제되었습니다", "/board/getList?category=" + category);
	}

	@PostMapping("/write")
	public void write(HttpServletResponse response, BoardVO gvo, @RequestParam("b_category") String category) {
		service.write(gvo);
		Alert.alertAndGo(response, "게시물이 등록되었습니다.", "/board/getList?category=" + category);
	}

	@GetMapping("/write") // 책 p.239 /write 중복이지만 이건 글쓰기 화면을 위한 url 매핑
	public void write() {
	}

	@PostMapping("/modify")
	public void modify(HttpServletResponse response, BoardVO gvo, @RequestParam("b_category") String category) {
		service.modify(gvo);
		Alert.alertAndGo(response, "게시물이 수정되었습니다.", "/board/getList?category=" + category);
	}

}
