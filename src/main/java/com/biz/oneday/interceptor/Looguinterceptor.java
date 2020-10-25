package com.biz.oneday.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.biz.oneday.service.SessionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Looguinterceptor extends HandlerInterceptorAdapter 
{
	@Qualifier("SessionV1")
	private final SessionService sessionservice;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception 
	{

		if(request.getSession().getAttribute("login_registration") == null)
		{
			log.debug("인터셉터 했음");
			sessionservice.alertLocation(response, "로그인 필요");
			return false;
		}
		return true;
	}
	


}
