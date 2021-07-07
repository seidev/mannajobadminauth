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
import com.mannajob.domain.PageDTO;
import com.mannajob.domain.QnaVO;
import com.mannajob.service.QnaService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/qna/*")
@AllArgsConstructor
public class QnaController {
	private QnaService service;
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("list paging...............");
		int total = service.getTotal(cri);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		return "/qna/list";
	}
	
	@GetMapping("/insert")
	public String insert(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("insert...............");
		return "/qna/insert";
	}
	
	@PostMapping("/insert")
	public String insert(QnaVO qna, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("insert >>> " + qna);
		service.insert(qna);
		return "redirect:/qna/list";
	}
	
	@PostMapping("/insertSub")
	public String insertSub(QnaVO qna, @ModelAttribute("cri") Criteria cri, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("insertSub >>> " + qna);
		service.insertSub(qna);
		return "redirect:/qna/view?q_num=" + qna.getQ_num() + "&pageNum=" + cri.getPageNum();
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("q_num") int q_num, @ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("view.....................");
		QnaVO qna = service.read(q_num);
		qna.setQ_contents(qna.getQ_contents().replace("\r\n", "<br>"));
		//model.addAttribute("qna", service.read(q_num));
		model.addAttribute("qna", qna);
		model.addAttribute("reply_chk",service.chkQnaSub(q_num));
		return "/qna/view";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("q_num") int q_num, @ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("update.....................");
		model.addAttribute("qna", service.read(q_num));
		return "/qna/update";
	}
	
	@PostMapping("/update")
	public String update(QnaVO qna, @ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("update >>> " + qna);
		service.update(qna);
		return "redirect:/qna/view?q_num=" + qna.getQ_num() + "&pageNum=" + cri.getPageNum();
	}
	
	@PostMapping("/updateSub")
	public String updateSub(QnaVO qna, @ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("updateSub >>> " + qna);
		service.updateSub(qna);
		return "redirect:/qna/view?q_num=" + qna.getQ_num() + "&pageNum=" + cri.getPageNum();
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("q_num") int q_num, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("delete............................");
		service.delete(q_num);
		return "redirect:/qna/list";
	}
	
	@PostMapping("/deleteSub")
	public String deleteSub(QnaVO qna, @ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("deleteSub >>> " + qna);
		service.deleteSub(qna);
		return "redirect:/qna/view?q_num=" + qna.getQ_num() + "&pageNum=" + cri.getPageNum();
	}
}
