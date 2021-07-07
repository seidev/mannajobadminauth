package com.mannajob.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mannajob.domain.BMatchVO;
import com.mannajob.service.BMatchService;
import com.mannajob.service.MatchService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/chart/*")
@AllArgsConstructor
public class ChartController {
	private MatchService matchservice;
	private BMatchService bmatchservice;
	@GetMapping("/chart_cnt")
	public void chart_cnt(Model model) {
		int max=0;
		for(int i=-6; i<=0; i++) {
			int match = matchservice.getDailycount(i);
			if(match > max) {
				max = match;
			}
			int bmatch = bmatchservice.getDailycount(i);
			if(bmatch>max) {
				max= bmatch;
			}
			Date date = bmatchservice.getDate(i);
			model.addAttribute("date"+(i+7), date);
			model.addAttribute("match"+(i+7),match);
			model.addAttribute("bmatch"+(i+7),bmatch);
		}
		model.addAttribute("max", max);
		log.info(model);
	}
	
	@GetMapping("/chart_cnt2")
	public void chart_cnt2(Model model) {
		int max=0;
		for(int i=-6; i<=0; i++) {
			int match = matchservice.getDailycount2(i);
			if(match > max) {
				max = match;
			}
			int bmatch = bmatchservice.getDailycount2(i);
			if(bmatch>max) {
				max= bmatch;
			}
			Date date = bmatchservice.getDate(i);
			model.addAttribute("date"+(i+7), date);
			model.addAttribute("match"+(i+7),match);
			model.addAttribute("bmatch"+(i+7),bmatch);
		}
		model.addAttribute("max", max);
		log.info(model);
	}
	
	@GetMapping("/chart_price")
	public void chart_price(Model model) {
		int max=0;
		for(int i=-6; i<=0; i++) {
			int price = bmatchservice.sumprice(i);
			if(price>max) {
				max= price;
			}
			Date date = bmatchservice.getDate(i);
			model.addAttribute("date"+(i+7), date);
			model.addAttribute("price"+(i+7), price);
		}
		model.addAttribute("max", max);
		log.info(model);
	}
	
	@GetMapping("/chart_price2")
	public void chart_price2(Model model) {
		int max=0;
		for(int i=-6; i<=0; i++) {
			int price = bmatchservice.sumprice2(i);
			if(price>max) {
				max= price;
			}
			Date date = bmatchservice.getDate(i);
			model.addAttribute("date"+(i+7), date);
			model.addAttribute("price"+(i+7), price);
		}
		model.addAttribute("max", max);
		log.info(model);
	}
	
	@GetMapping("/chart_field")
	public void chart_field(Model model) {
		int max_corp=0;
		int max_location=0;
		int max_task=0;
		List<BMatchVO> corp= bmatchservice.rankCorp();
		List<BMatchVO> location = bmatchservice.rankLocation();
		List<BMatchVO> task = bmatchservice.rankTask();
		for(int i=0; i<corp.size(); i++) {
			 if(max_corp < corp.get(i).getCnt()) {
				 max_corp = corp.get(i).getCnt();
			 }
		}
		 for(int i=0; i<location.size(); i++) {
			 if(max_location < location.get(i).getCnt()) {
				 max_location = location.get(i).getCnt();
			 }
		 }
		 for(int i=0; i<task.size(); i++) {
			 if(max_task < task.get(i).getCnt()) {
				 max_task = task.get(i).getCnt();
			 }
		 }
		
		model.addAttribute("maxcorp", max_corp);
		model.addAttribute("maxlocation", max_location);
		model.addAttribute("maxtask", max_task);
		model.addAttribute("rankCorp", corp);
		model.addAttribute("rankLocation", location);
		model.addAttribute("rankTask", task);
	}
}
