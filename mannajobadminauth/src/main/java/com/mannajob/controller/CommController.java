package com.mannajob.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mannajob.domain.CommVO;
import com.mannajob.service.CommService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/comm/*")
@AllArgsConstructor
public class CommController {
	private CommService service;
	
	@PostMapping("/insert")
	public String insert(CommVO comm, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("insert >>> " + comm);
		service.insert(comm);
		return "/bmatch/viewempl";
	}
	
	@PostMapping("/insertSub")
	public String insertSub(CommVO comm, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("insertSub >>> " + comm);
		service.insertSub(comm);
		return "/bmatch/viewempl";
	}
	
	@PostMapping("/update")
	public String update(CommVO comm, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("update >>> " + comm);
		service.update(comm);
		return "/bmatch/viewempl";
	}
	
	@PostMapping("/updateSub")
	public String updateSub(CommVO comm, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("updateSub >>> " + comm);
		service.updateSub(comm);
		return "/bmatch/viewempl";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("cm_num") int cm_num, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("delete............................");
		service.delete(cm_num);
		return "/bmatch/viewempl";
	}
	
	@PostMapping("/deleteSub")
	public String deleteSub(@RequestParam("cms_num") int cms_num, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		log.info("deleteSub............................");
		service.deleteSub(cms_num);
		return "/bmatch/viewempl";
	}
}
