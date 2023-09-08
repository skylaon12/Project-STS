package com.skylaon.spring.sm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylaon.spring.sm.mapper.BoardMapper;
import com.skylaon.spring.sm.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	// 리스트
	@Override
	public ArrayList<BoardVO> getList(String category) {
		log.info("비지니스 계층===========");
		//int limitIndex = (currentPage-1) * 5;
		return mapper.getList(category);
	}

	// 읽기
	@Override
	public BoardVO read(int bno) {
		return mapper.read(bno);
	}

	@Override
	public void del(int bno) {
		mapper.del(bno);
	}

	@Override
	public void write(BoardVO gvo) {
		mapper.write(gvo);
	}

	@Override
	public void modify(BoardVO gvo) {
		log.info("입력받은 title : " + gvo.getB_title());
		log.info("입력받은 text : " + gvo.getB_text());
		log.info("입력받은 category : " + gvo.getB_category());
		mapper.modify(gvo);
	}

	@Override
	public int getPostCount() {
		return mapper.getPostCount();
	}

//	@Override
//	public BoardListProcessor list(String currentPage){
//		log.info("서비스에서 호출");
//		if(currentPage == null) {
//			currentPage = "1";
//		}
//		BoardListProcessor blp;
//		try {
//			blp = new BoardListProcessor(mapper, currentPage);
//			return blp;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}


}
