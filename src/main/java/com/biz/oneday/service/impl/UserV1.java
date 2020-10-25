package com.biz.oneday.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.oneday.dao.UserDAO;
import com.biz.oneday.dto.UserVO;
import com.biz.oneday.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service("UserServiceV1")
public class UserV1 implements UserService
{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<UserVO> selectAll() 
	{
		return userDAO.selectAll();
	}
	
	@Override
	public UserVO findById(String id) {
		return null;
	}
		
	@Override
	public int insert(UserVO vo) 
	{
		int ret = userDAO.insert(vo);
		return ret;
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkByUser(UserVO vo, int check) {
		// TODO Auto-generated method stub
		return false;
	}

}
