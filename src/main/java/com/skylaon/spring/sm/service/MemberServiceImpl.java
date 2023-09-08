package com.skylaon.spring.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylaon.spring.sm.mapper.MemberMapper;
import com.skylaon.spring.sm.service.exception.CustomRegistrationException;
import com.skylaon.spring.sm.vo.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberServiceImpl implements MemberService{

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Override
	public MemberVO login(MemberVO uvo) {
		log.info("로그인 service 진입");
		log.info("아이디 = " + uvo.getU_id());
		log.info("비밀번호 = " + uvo.getU_pw());
		return mapper.login(uvo);
	}

	@Override
	public boolean register(MemberVO uvo) {
		try {
			mapper.register(uvo);
			return true;
		}catch(Exception e) {
			throw new CustomRegistrationException("회원가입 중 오류 발생", e);
		}
	}

}
