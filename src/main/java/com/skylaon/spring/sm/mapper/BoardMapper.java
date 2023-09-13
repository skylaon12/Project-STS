package com.skylaon.spring.sm.mapper;

import java.util.ArrayList;

import com.skylaon.spring.sm.vo.BoardVO;
import com.skylaon.spring.sm.vo.ExamVO;

public interface BoardMapper {
	//  리스트
	public ArrayList<BoardVO> getList(ExamVO evo);
	
	// read
	public BoardVO read(int b_no);
	
	// del
	public void del(int b_no);
	
	// write
	public void write(BoardVO gvo);
	
	// modify
	public void modify(BoardVO gvo);
	
	public int getTotalCount(String b_category);
	
}
