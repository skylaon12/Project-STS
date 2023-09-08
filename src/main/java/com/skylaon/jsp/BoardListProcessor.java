package com.skylaon.jsp;

import java.util.ArrayList;

import com.skylaon.spring.sm.mapper.BoardMapper;
import com.skylaon.spring.sm.vo.BoardVO;

public class BoardListProcessor {

	private BoardMapper mapper;

	public String category;
	public ArrayList<BoardVO> posts;
	public int totalPage = 0; // 전체페이지 수
	public int currentPage = 0; // 현재 페이지 번호

	// {블럭 처리 - 1/9}.블럭 총 갯수 구하기//
	int totalBlock = 0;
	// {블럭 처리 - 2/9}.현재 블럭 번호 구하기//
	int currentBlockNo = 0;
	// {블럭 처리 - 3/9}.블럭 시작 페이지 번호 구하기
	int blockStartNo = 0;
	// {블럭 처리 - 4/9}.블럭 끝 페이지 번호 구하기
	int blockEndNo = 0;
	// {블럭 처리 - 5/9}.(이전/다음) 관련 초기화 처리
	int prevPage = 0;
	int nextPage = 0;
	// {블럭 처리 - 6/9}.(이전/다음) 관련 계산 등 처리
	boolean hasPrev = true;
	boolean hasNext = true;

	public BoardListProcessor(BoardMapper mapper, String currentPage) throws Exception {
		this.mapper = mapper;
		this.currentPage = Integer.parseInt(currentPage);
		this.totalPage = getTotalPageCount();
		getList();
		// 총 블럭 수 = 전체 페이지 / 블럭 당 페이지 수 (올림)
		totalBlock = (int) Math.ceil((double) totalPage / 5);
		// 현재 블럭 번호 = 현재 페이지 / 블럭 당 페이지 수 (올림)
		currentBlockNo = (int) Math.ceil((double) this.currentPage / 5);
		// 블럭 시작 페이지 번호 = (현재 블럭 번호 -1) * 블럭 당 페이지 수 + 1
		blockStartNo = (currentBlockNo - 1) * 5 + 1;
		// 블럭 끝 페이지 번호 = 현재 블럭 번호 * 블럭 당 페이지 수
		// 블럭끝페이지번호 = 블럭끝페이지번호>전체페이지수)?전체페이지수:블럭끝페이지번호
		blockEndNo = currentBlockNo * 5;
		if (blockEndNo > totalPage) {
			blockEndNo = totalPage;
		}

		// (이전/다음) 관련 계산
		// 현재 블럭에서 이전/다음 가능 여부 확인
		if (currentBlockNo == 1) { // 현재 블럭이 1이면
			hasPrev = false; // 이전 블럭 비활성화
		} else {
			hasPrev = true; // 이전 블럭 활성화
			// 이전 블럭 이동 시 몇 페이지로 이동할지 정하기
			// 이전 블럭의 마지막 페이지로 이동하게 하면 된다.
			prevPage = (currentBlockNo - 1) * 5;
		}
		if (currentBlockNo < totalBlock) {
			hasNext = true;
			// 다음 블럭 이동 시 몇 페이지로 이동할지 정하기
			// 다음 블럭의 첫 페이지로 이동하게 하면 된다.
			nextPage = currentBlockNo * 5 + 1;
		} else {
			hasNext = false;
		}
	}

	public void getList() {
		int startIndex = (currentPage - 1) * 5;
		posts = mapper.getList(startIndex);
	}

	public int getTotalPageCount() throws Exception {
		int count = mapper.getPostCount();// 게시물 수
		int totalPageCount = 0;

		if (count % 5 == 0) { // case
			totalPageCount = count / 5;
		} else { // case2. 나머지가 있어서 짜투리 페이지가 필요한 경우
			totalPageCount = count / 5 + 1;
		}
		return totalPageCount;
	}

	// 글 리스트 객체 얻는 함수
	public ArrayList<BoardVO> getPosts() {
		return posts;
	}

	// 페이지 리스트들을 출력하기 위한 html을 리턴
	public String getHtmlPageList() {
		String html = "";

		// {블럭 처리 - 8/9}.
		if (hasPrev) {
			html = html + String.format(
					"<a class='arrow prev' href='/board/list?&page=%d'><img src='/img/page_prev.png' alt='이전'></a>",
					category, prevPage);
		}
		for (int i = blockStartNo; i <= blockEndNo; i++) { // << 이렇게 바꿈
			html = html + String.format("<a href='/board/list?&page=%d'>%d</a>&nbsp;&nbsp;", category, i, i);
		}

		// {블럭 처리 - 9/9}.
		if (hasNext) {
			html = html + String.format(
					"<a class='arrow next' href='/board/list?&page=%d'><img src='/img/page_next.png' alt='다음'></a>",
					category, nextPage);
		}
		return html;
	}
}
