package com.biz.oneday.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.oneday.dto.UserVO;
import com.biz.oneday.service.SessionService;
import com.biz.oneday.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


// 1 == 아이디, 비밀번호 체크, 2 == 아이디 체크
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/user")
@Controller
public class Usercontroller 
{	
		@Autowired
		@Qualifier("UserServiceV2")
		private UserService userservice;
		
		@Qualifier("SessionV1")
		private final SessionService sessionservice;

		@RequestMapping(value={"/",""}, method=RequestMethod.GET)
		public String home()
		{
			return "home";
		}
				
		@RequestMapping(value={"/login","/login/"}, method=RequestMethod.GET)
		public String login(Model model, @ModelAttribute("userVO") UserVO userVO)
		{
			model.addAttribute("BODY", "USER_LOGIN");
			return "home";
		}
		
		@RequestMapping(value={"/login","/login/"}, method=RequestMethod.POST)
		public String login(HttpServletRequest req, @ModelAttribute("userVO") UserVO vo)
		{

			if(userservice.checkByUser(vo, 2) == true)
				sessionservice.sessionRegistration(req, vo);
			
			return "redirect:/clothing/list";
		}
		
		@RequestMapping(value={"/logout","/logout/"}, method=RequestMethod.GET)
		public String logout(HttpServletRequest req)
		{
			UserVO vo = (UserVO) req.getSession().getAttribute("login_registration");
			sessionservice.sessionRegistration(req, vo);
			return "home";
		}
		
		@RequestMapping(value= {"/join", "/join/"}, method = RequestMethod.GET)
		public String getJoin(Model model, @ModelAttribute("userVO") UserVO userVO)
		{
			model.addAttribute("BODY", "USER_JOIN");
			return "home";
		}
		
		@RequestMapping(value= {"/join", "/join/"}, method = RequestMethod.POST)
		public void PostJoin(Model model, @ModelAttribute("userVO") UserVO userVO, HttpServletResponse res) throws IOException
		{
			if(userservice.checkByUser(userVO, 1))
			{
				userservice.insert(userVO);
				sessionservice.alertLocation(res, "회원가입 성공");
			}
			else
				sessionservice.alertLocation(res, "중복된 아이디 입니다.");
		}

		
}
