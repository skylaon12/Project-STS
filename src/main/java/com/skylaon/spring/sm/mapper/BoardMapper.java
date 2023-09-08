package com.skylaon.spring.sm.mapper;

import java.util.ArrayList;

import com.skylaon.spring.sm.vo.BoardVO;

public interface BoardMapper {
	//  리스트
	public ArrayList<BoardVO> getList(String b_category);
	
	// read
	public BoardVO read(int b_no);
	
	// del
	public void del(int b_no);
	
	// write
	public void write(BoardVO gvo);
	
	// modify
	public void modify(BoardVO gvo);
	
	public int getPostCount();
}
