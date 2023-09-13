package com.skylaon.spring.sm.service;

import java.util.ArrayList;

import com.skylaon.spring.sm.vo.BoardVO;

public interface BoardService {
	public ArrayList<BoardVO> getList(String category, int index);
	public BoardVO read(int bno);	// read
	public void del(int bno); 		// delete
	public void write(BoardVO bvo);	// write
	public void modify(BoardVO bvo);// update
	
	
	// 페이징 관련
	public int getStartIndex(int page);
	public int getTotalCount(String category);
	public int getTotalPage(String category);
	public int getTotalBlock(int totalPage);
	

	
}
