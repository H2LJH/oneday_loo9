package com.biz.oneday.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.oneday.dto.UserVO;

public interface SessionService 
{
	public boolean sessionRegistration(HttpServletRequest req, UserVO vo);
	public void alertLocation(HttpServletResponse response, String text) throws IOException;
	
}
