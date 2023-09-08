package com.skylaon.spring.sm.service;

import java.util.ArrayList;

import com.skylaon.spring.sm.vo.BoardVO;

public interface BoardService {
	public ArrayList<BoardVO> getList(String category);	// 리스트
	public BoardVO read(int bno);	// read
	public void del(int bno); 		// delete
	public void write(BoardVO bvo);	// write
	public void modify(BoardVO bvo);// update
	
	public int getPostCount();
	
	//public BoardListProcessor list(String currentPage);
}
