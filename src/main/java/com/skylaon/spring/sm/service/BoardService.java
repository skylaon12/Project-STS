package com.skylaon.spring.sm.service;

import java.util.ArrayList;
import java.util.List;

import com.skylaon.spring.sm.vo.BoardVO;

public interface BoardService {
	public ArrayList<BoardVO> getList(String category, int index);
	public BoardVO read(int bno);	// read
	public void del(int bno); 		// delete
	public void write(BoardVO bvo);	// write
	public void modify(BoardVO bvo);// update
	public ArrayList<BoardVO> getSearchList(String word, String category, int index);
	
	// 페이징 관련
	public int getStartIndex(int page);
	public int getTotalCount(String category);
	public int getTotalCount(String word, String category);
	public int getTotalPage(String category);
	public int getTotalPage(int totalCount, String word, String category);
	public int getTotalBlock(int totalPage);
	
	// 댓글
	public List<BoardVO> getComment(int bno); 
	public boolean setComment(BoardVO gvo);
	public void del(int bno, int ori_no); 		// delete

	
}
