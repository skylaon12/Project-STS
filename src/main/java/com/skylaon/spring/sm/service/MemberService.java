package com.skylaon.spring.sm.service;

import com.skylaon.spring.sm.vo.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO uvo);
	public boolean register(MemberVO uvo);
}
