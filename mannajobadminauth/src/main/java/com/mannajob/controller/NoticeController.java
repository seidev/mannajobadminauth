package com.mannajob.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mannajob.domain.Criteria;
import com.mannajob.domain.NoticeVO;
import com.mannajob.domain.PageDTO;
import com.mannajob.service.NoticeService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/notice/*")
@AllArgsConstructor
public class NoticeController {
	private NoticeService service;
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("list paging...............");
		int total = service.getTotal(cri);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		return "/notice/list";
	}
	
	@GetMapping("/insert")
	public String insert(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("insert...............");
		return "/notice/insert";
	}
	
	@PostMapping("/insert")
	public String insert(NoticeVO notice, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("insert >>> " + notice);
		service.insert(notice);
		return "redirect:/notice/list";
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("n_num") int n_num, @ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("view.....................");
		service.readUpCount(n_num);
		NoticeVO notice = service.read(n_num);
		notice.setN_contents(notice.getN_contents().replace("\r\n", "<br>"));
		//model.addAttribute("notice", service.read(n_num));
		model.addAttribute("notice", notice);
		return "/notice/view";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("n_num") int n_num, @ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("update.....................");
		model.addAttribute("notice", service.read(n_num));
		return "/notice/update";
	}
	
	@PostMapping("/update")
	public String update(NoticeVO notice, @ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("update >>> " + notice);
		service.update(notice);
		return "redirect:/notice/view?n_num=" + notice.getN_num() + "&pageNum=" + cri.getPageNum();
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("n_num") int n_num, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("delete............................");
		service.delete(n_num);
		return "redirect:/notice/list";
	}
}
