package com.mannajob.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mannajob.domain.MemberVO;
import com.mannajob.service.JoinService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/join/*")
@AllArgsConstructor
public class JoinController {
	private JoinService service;
	
	@GetMapping("/member")
	public String insert(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		return "/join/member";
	}
	
	//	약관동의 화면
	@GetMapping("/member_agree")
	public String member_agree(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		return "/join/member_agree";	
	}
	
	
		
	@PostMapping("/member")
	public String insert(MemberVO member) {
		service.MemJoin(member);
		return "redirect:/login";
	}
	
	@GetMapping("/join")
	public String insertapi(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		return "/join/join";
	}
	
	@PostMapping("/join")
	public String insertapi(MemberVO member, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		member.setM_id(session.getAttribute("sessionId").toString());
		member.setM_api(session.getAttribute("userapi").toString());
		service.ApiJoin(member);
		session.setAttribute("userId", session.getAttribute("sessionId"));
		return "redirect:/main";
	}
	
}
