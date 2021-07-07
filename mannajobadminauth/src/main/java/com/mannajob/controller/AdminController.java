package com.mannajob.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mannajob.domain.Criteria;
import com.mannajob.domain.EmplFileVO;
import com.mannajob.domain.MemberVO;
import com.mannajob.domain.PageDTO;
import com.mannajob.domain.SearchVO;
import com.mannajob.service.AdminService;
import com.mannajob.service.ProfileService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/*")
@AllArgsConstructor
public class AdminController {
	private AdminService service; 
	private ProfileService pservice;
	
	@GetMapping("/manage")
	public String manage(Model model, Criteria cri, SearchVO search, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		int total = service.getTotal(cri, search);
		model.addAttribute("memlist", service.getMemListWithPaging(cri, search));
		model.addAttribute("mempageMaker", new PageDTO(cri, total));
		model.addAttribute("searchType", search.getSearchType());
		model.addAttribute("keyword", search.getKeyword());
		return "/admin/manage";
	}
	
	@GetMapping("/manageShowMem")
	public String moveboard(Model model, String m_id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		model.addAttribute("m_id", m_id);
		model.addAttribute("MReview", pservice.searchReview(m_id));
		return "/admin/manageShowMem";
	}
	
	@GetMapping("/reset")
	public String resetPasswd(MemberVO member, RedirectAttributes rttr, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		//service.resetPasswd(m_id); //평문
		service.resetPasswdEnc(member);
		rttr.addFlashAttribute("result", 1);
		return "redirect:/admin/manage";
	}

	@GetMapping("/check")
	public String check(Criteria cri, SearchVO search, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		int total = service.getemplTotal(search);
		model.addAttribute("empllist", service.getEmplListWithPaging(cri, search));
		model.addAttribute("emplpageMaker", new PageDTO(cri, total));
		model.addAttribute("searchType", search.getSearchType());
		model.addAttribute("keyword", search.getKeyword());
		return "/admin/check";
	}

	@GetMapping("/emplOk")
	public String emplOk(int e_num, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		service.emplOk(e_num);
		return "redirect:/admin/check";
	}
	
	@GetMapping("/emplapply")
	public String emplapply(int e_num, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		
		EmplFileVO emplfileVO = service.emplApply(e_num);
		model.addAttribute("emplFile", emplfileVO);
		model.addAttribute("profile",emplfileVO.getStored_file_name());
		System.out.println(emplfileVO.toString());
		return "/admin/emplapply";
	}
	
	@GetMapping("/certif")
	public String certif(HttpSession session, @RequestParam("e_num") int e_num, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		model.addAttribute("emplCertif",  service.emplImage(e_num));
		return "/admin/certif";
	}
}
