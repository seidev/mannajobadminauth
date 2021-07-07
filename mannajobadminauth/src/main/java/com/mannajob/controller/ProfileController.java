package com.mannajob.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mannajob.domain.EmplVO;
import com.mannajob.domain.MemberVO;
import com.mannajob.service.ProfileService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/profile/*")
public class ProfileController {
	@Autowired
	private ProfileService service;
	private MemberVO member;
	private EmplVO empl;
	
	@GetMapping("/main")
	public String main(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		member = service.getMemProfile(session.getAttribute("userId").toString());
		
		model.addAttribute("userId", member.getM_id());
		model.addAttribute("username", member.getM_name());
		model.addAttribute("userphone", member.getM_phone());
		model.addAttribute("useremail", member.getM_email());

		session.setAttribute("empl", service.getEmplProfile(session.getAttribute("userId").toString()));
		
		if(empl != null) {
			model.addAttribute("emplcorp", empl.getE_corp());
			model.addAttribute("empldept", empl.getE_dept());
			model.addAttribute("emplrank", empl.getE_rank());
			model.addAttribute("empltask", empl.getE_task());
			model.addAttribute("emplcareer", empl.getE_career());
			model.addAttribute("emplintro", empl.getE_intro());
			model.addAttribute("emplok", empl.getE_ok());
		}

		
		return "profile/main";
	}
	
	// empl.jsp
	@GetMapping("/empl")
	public String EmplJoin(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		System.out.println(session.getAttribute("userId"));
		model.addAttribute("userId", session.getAttribute("userId"));
		return "/profile/empl";
	}
			
	//EmplVO INSERT 
	@PostMapping("/empl")
	public String EmplJoin(EmplVO empl, RedirectAttributes rttr, MultipartHttpServletRequest mpRequest, HttpSession session) throws Exception {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("empl: " + empl);
		service.EmplJoin(empl, mpRequest);
		return "redirect:/match/matlist";
	}
	
	@GetMapping("/update")
	public String update(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		member = service.getMemProfile(session.getAttribute("userId").toString());
		model.addAttribute("member", member);
		return "profile/update";
	}
	
	@PostMapping("/update")
	public String update(MemberVO member, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info(member.toString());
		service.updateProfile(member);
		return "redirect:/profile/main";
	}
	
	@GetMapping("/deleteMem")
	public String deleteMem(String m_id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		service.deleteMem(m_id);
		return "redirect:/login";
	}
	
	@GetMapping("/emplprofile")
	public String emplprofile(Model model, HttpSession session, RedirectAttributes rttr) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		String m_id = session.getAttribute("userId").toString();
		if(service.cheakEmpl(m_id)) {
		empl = service.getEmplProfile2(m_id);
		
		model.addAttribute("userId", m_id);
		model.addAttribute("imageFile", empl.getFileVO().getStored_file_name());
		model.addAttribute("emplcorp", empl.getE_corp());
		model.addAttribute("empldept", empl.getE_dept());
		model.addAttribute("emplrank", empl.getE_rank());
		model.addAttribute("empltask", empl.getE_task());
		model.addAttribute("emplcareer", empl.getE_career());
		model.addAttribute("emplintro", empl.getE_intro());
		
		model.addAttribute("emplreview", service.searchReview(m_id));
		return "/profile/emplprofile";
		}else {
			rttr.addFlashAttribute("error", 1);
			return "redirect:/profile/empl";
		}
	}
//	다른사람들의  프로필 접근 화면 화면(리스트)
	@GetMapping("/showempl")
	public String showempl(Model model, EmplVO emplVO, HttpSession session, @RequestParam("pagetype") String pagetype) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		model.addAttribute("m_id",emplVO.getM_id());
		model.addAttribute("empl",service.getEmplProfile2(emplVO.getM_id()));
		model.addAttribute("image",service.getEmplProfile2(emplVO.getM_id()).getFileVO().getStored_file_name());
		model.addAttribute("review", service.searchReview(emplVO.getM_id()));
		model.addAttribute("good", service.countG(emplVO.getM_id()));
		model.addAttribute("count", service.totalMat(emplVO.getM_id()));
		model.addAttribute("pagetype", pagetype);
		return "/profile/showempl";
	}


	//	마이페이지 자신의 현직자 프로필 변경 화면
	@GetMapping("/updateEmpl")
	public String emplupdate(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		EmplVO emplVO = service.getEmplProfile2(session.getAttribute("userId").toString());
		model.addAttribute("empl", emplVO);
		model.addAttribute("profile", emplVO.getFileVO().getStored_file_name());
		return "/profile/updateEmpl";
	}
	
	@PostMapping("/updateEmpl")
	public String emplupdate(EmplVO empl, Model model, MultipartHttpServletRequest mpRequest, HttpSession session) throws Exception {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		service.updateEmpl(empl, mpRequest);
		model.addAttribute("userId", empl.getM_id());
		model.addAttribute("imageFile", service.getEmplProfile2(model.getAttribute("userId").toString()).getFileVO().getStored_file_name());
		model.addAttribute("emplcorp", empl.getE_corp());
		model.addAttribute("empldept", empl.getE_dept());
		model.addAttribute("emplrank", empl.getE_rank());
		model.addAttribute("empltask", empl.getE_task());
		model.addAttribute("emplcareer", empl.getE_career());
		model.addAttribute("emplintro", empl.getE_intro());
		return "redirect:/profile/emplprofile";
	}
	
	@PostMapping("/deleteEmpl")
	public String deleteEmpl(String m_id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		service.deleteEmpl(m_id);
		return "redirect:/profile/main";
	}
	
	@GetMapping("/showmem")
	public String showmem(Model model, String m_id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info(".............................................." + session.getAttribute("userId").toString());
		model.addAttribute("userId", session.getAttribute("userId").toString());
		model.addAttribute("m_id", m_id);
		model.addAttribute("MReview", service.searchReview(m_id));
		return "/profile/showmem";
	}
	
	@GetMapping("/suggest")
	public String suggest(Model model, String m_id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		return "/profile/suggest";
	}
}
