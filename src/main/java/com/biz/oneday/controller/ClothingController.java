package com.biz.oneday.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.oneday.dto.ClothingVO;
import com.biz.oneday.service.ClothingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value="/clothing")
@Controller
public class ClothingController {

	@Qualifier("ClothingV1")
	private final ClothingService clothingService;
	
	@RequestMapping(value= {"/list", "/list/"}, method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest req)
	{
		model.addAttribute("CLOTING", clothingService.findByUserList(req));
		model.addAttribute("BODY", "CLOTING_LIST");
		return "home";
	}
	
	@RequestMapping(value= {"/write", "/write/"}, method= RequestMethod.GET)
	public String insert(Model model, @ModelAttribute("clothingVO")ClothingVO vo)
	{
		model.addAttribute("BODY", "CLOTHING_WRITE");
		return "home";
	}
	
	@RequestMapping(value= {"/write", "/write/"}, method= RequestMethod.POST)
	public String insert(HttpServletRequest req, @ModelAttribute("clothingVO")ClothingVO vo)
	{
		clothingService.insert(vo,req);
		return "redirect:list";
	}
	
	/*
	 * @RequestMapping(value = {"/update"}, method=RequestMethod.POST) public void
	 * update(@RequestParam )
	 */
	
	@ResponseBody
	@RequestMapping(value= {"/delete", "/delete/"}, method=RequestMethod.POST)
	public void delete(HttpServletRequest req, @RequestParam String delete_seq[])
	{
		clothingService.selected_delete(delete_seq);
	}
	
	@RequestMapping(value= {"/detail", "/detail/{io_pname}"}, method=RequestMethod.GET)
	public String detail(Model model, @PathVariable("io_pname") String io_pname, HttpServletRequest req)
	{

		model.addAttribute("BODY", "CLOTHING_DETAIL");
		model.addAttribute("DETAIL_LIST", clothingService.findByDetailList(io_pname, req));
		return "home";
	}
	
	
}
