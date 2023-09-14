package com.skylaon.spring.sm.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.skylaon.spring.sm.vo.BoardVO;

public interface BoardMapper {
	//  리스트
	public ArrayList<BoardVO> getList(@Param("b_category") String b_category, @Param("index") int index);
	
	// read
	public BoardVO read(int b_no);
	
	// del
	public void del(int b_no);
	
	// write
	public void write(BoardVO gvo);
	
	// modify
	public void modify(BoardVO gvo);
	
	//search
	public ArrayList<BoardVO> getSearchList(@Param("word")String word, @Param("b_category") String b_category, @Param("index") int index);
	
	public int getTotalCount(String b_category);
	public int getSearchTotalCount(@Param("word")String word, @Param("b_category") String b_category);
	
	
}
