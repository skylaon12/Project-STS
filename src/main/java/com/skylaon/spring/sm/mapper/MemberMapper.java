package com.skylaon.spring.sm.mapper;

import org.springframework.stereotype.Repository;

import com.skylaon.spring.sm.vo.MemberVO;

@Repository
public interface MemberMapper {

	public MemberVO login(MemberVO uvo);
	public void register(MemberVO uvo);
}
