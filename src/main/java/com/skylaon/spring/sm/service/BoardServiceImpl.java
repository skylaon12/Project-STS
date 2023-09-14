package com.skylaon.spring.sm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylaon.spring.sm.board.ConfigBoard;
import com.skylaon.spring.sm.mapper.BoardMapper;
import com.skylaon.spring.sm.service.exception.CommentRegistraionException;
import com.skylaon.spring.sm.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	// 리스트
	@Override
	public ArrayList<BoardVO> getList(String category, int index) {
		return mapper.getList(category, index);
	}
	
	// 검색
	@Override
	public ArrayList<BoardVO> getSearchList(String word, String category, int index) {
		return mapper.getSearchList(word, category, index);
		
	}
	
	// 읽기
	@Override
	public BoardVO read(int bno) {
		mapper.hitCountPlus(bno);
		return mapper.read(bno);
	}
	
	// 삭제
	@Override
	public void del(int bno) {
		mapper.del(bno);
	}
	
	// 쓰기
	@Override
	public void write(BoardVO gvo) {
		mapper.write(gvo);
	}
	// 수정
	@Override
	public void modify(BoardVO gvo) {
		log.info("입력받은 title : " + gvo.getB_title());
		log.info("입력받은 text : " + gvo.getB_text());
		log.info("입력받은 category : " + gvo.getB_category());
		mapper.modify(gvo);
	}
	// 시작인덱스
	@Override
	public int getStartIndex(int page) {
		int index = (page - 1) * ConfigBoard.AMOUNT_PER_PAGE;
		return index;
	}
	// 전체 게시물 수
	@Override
	public int getTotalCount(String category) {
		return mapper.getTotalCount(category);
	}
	// 전체 게시물 수(검색)
	@Override
	public int getTotalCount(String word, String category) {
		//ExamVO evo = new ExamVO(word, category);
		return mapper.getSearchTotalCount(word, category);
	}
	// 전체 페이지 수
	@Override
	public int getTotalPage(String category) {
		// 전체 페이지 수 = 전체 글 수 / [페이지당 글 수]
		int totalCount = getTotalCount(category);
		int totalPage = 0;
		if (totalCount % ConfigBoard.AMOUNT_PER_PAGE == 0) {
			totalPage = totalCount / ConfigBoard.AMOUNT_PER_PAGE;
		} else {
			totalPage = totalCount / ConfigBoard.AMOUNT_PER_PAGE + 1;
		}
		return totalPage;
	}
	//전체 페이지 수(검색)
	@Override
	public int getTotalPage(int totalCount, String word, String category) {
		// 전체 페이지 수 = 전체 글 수 / [페이지당 글 수]
		int totalPage = 0;
		if (totalCount % ConfigBoard.AMOUNT_PER_PAGE == 0) {
			totalPage = totalCount / ConfigBoard.AMOUNT_PER_PAGE;
		} else {
			totalPage = totalCount / ConfigBoard.AMOUNT_PER_PAGE + 1;
		}
		return totalPage;
	}
	// 전체 블럭 수
	@Override
	public int getTotalBlock(int totalPage) {
		// 전체 블럭 수 = 전체 페이지 수 / [블럭당 페이지 수]
		int totalBlock = 0;
		if (totalPage % ConfigBoard.PAGE_PER_BLOCK == 0) {
			totalBlock = totalPage / ConfigBoard.PAGE_PER_BLOCK;
		} else {
			totalBlock = totalPage / ConfigBoard.PAGE_PER_BLOCK + 1;
		}
		return totalBlock;
	}
	
	// 댓글목록
	@Override
	public List<BoardVO> getComment(int bno) {
		return mapper.getComment(bno);
	}
	
	// 댓글 작성
	@Override
	public boolean setComment(BoardVO gvo) {
		try {
			mapper.setComment(gvo);
			mapper.commentCountPlus(gvo);
			return true;
		}catch(Exception e) {
			throw new CommentRegistraionException("댓글 작성 중 오류 발생");
		}
		
	}
	// 댓글 삭제
	@Override
	public void del(int bno, int ori_no) {
		mapper.del(bno);
		mapper.commentCountMinus(ori_no);
	}
	
	
	

	

}
