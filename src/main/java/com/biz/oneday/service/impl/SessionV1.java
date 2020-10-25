package com.biz.oneday.service.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.biz.oneday.dto.UserVO;
import com.biz.oneday.service.SessionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("SessionV1")
public class SessionV1 implements SessionService
{
	public boolean sessionRegistration(HttpServletRequest req, UserVO vo) 
	{
		if(req.getSession().getAttribute("login_registration") != null)
		{
			req.getSession().removeAttribute("login_registration");
			log.debug("로그아웃 성공");
			return false;
		}
		
		req.getSession().setAttribute("login_registration", vo);
		log.debug("로그인 성공");
		return true;
	}


	
	@Override
	public void alertLocation(HttpServletResponse response, String text) throws IOException 
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		out = response.getWriter();
		
		out.println("<script language='javascript'>");
		out.println("alert('"+ text +"')");
		out.println("document.location.href='/oneday/'");
		out.println("</script>");
		out.flush();
		out.close();		
	}


}
	

