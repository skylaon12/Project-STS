package com.skylaon.spring.sm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skylaon.spring.sm.service.MemberService;
import com.skylaon.spring.sm.vo.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/member/*")
@AllArgsConstructor
@Controller
public class MemberController {
	private MemberService service;

	@RequestMapping("/login")
	public void login() {

	}

	@RequestMapping("/loginproc")
	public String loginProc(HttpSession s, MemberVO uvo) {
		MemberVO isLogin = service.login(uvo);
		if (isLogin != null) {
			log.info(isLogin.getU_name());
			s.setAttribute("user", isLogin);
		} else {
			log.info("회원정보 널값임");
		}
		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String loginProc(HttpSession s) {
		s.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value = "/regProc", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> regProc(@RequestBody MemberVO mvo) {
		// todo
		boolean success = false;
		String message = "이미 사용중인 아이디입니다.";
		log.info("====================");
		log.info("아이디 : " + mvo.getU_id());
		
		success = service.register(mvo);
		
		Map<String,Object> response = new HashMap<>();
		
		response.put("success", success);
		response.put("message", message);
		
		log.info("회원가입 완료");
		
		return ResponseEntity.ok(response);
	}

}
