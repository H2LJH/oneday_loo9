package com.biz.oneday.service.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.biz.oneday.dao.ClothingDAO;
import com.biz.oneday.dto.ClothingVO;
import com.biz.oneday.dto.UserVO;
import com.biz.oneday.service.ClothingService;
import com.biz.oneday.service.DateService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("ClothingV1")
public class ClothingV1 implements ClothingService
{
	
	private final ClothingDAO cloDAO;
	private final DateService dateService;
	
	@Override
	public List<ClothingVO> selectAll() {
		List<ClothingVO> cloList = cloDAO.selectAll();
		return cloList;
	}
	
	@Override
	public List<ClothingVO> findByUserList(HttpServletRequest req) 
	{
		UserVO uservo = (UserVO) req.getSession().getAttribute("login_registration");
		uservo.getU_id();
		return cloDAO.findByClothingList(uservo.getU_id());
	}
	
	public List<ClothingVO> findByDetailList(String io_pname, HttpServletRequest req) 
	{
		 UserVO vo = (UserVO) req.getSession().getAttribute("login_registration");
		 List<ClothingVO> DetailList = cloDAO.findByDetailList(io_pname, vo.getU_id());
		return DetailList;
	}
	
	@Override
	public ClothingVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ClothingVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int insert(ClothingVO vo, HttpServletRequest req) 
	{
		UserVO uservo = (UserVO) req.getSession().getAttribute("login_registration");
		vo.setIo_user(uservo.getU_id());
		
		vo.setIo_date(dateService.dateTime()[0]);
		vo.setIo_time(dateService.dateTime()[1]);
		
		
		System.out.println(vo.toString());
		
		int ret = cloDAO.insert(vo);
		return ret;
	}
	@Override
	public int update(ClothingVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selected_delete(String[] pk) 
	{ 
		Long[] seqNum = new Long[pk.length];
		
		for(int i=0; i<pk.length; ++i)
			seqNum[i] = Long.valueOf(pk[i]);
		
		for(int i=0; i<pk.length; ++i)
			cloDAO.delete(seqNum[i]);
			
		return 0;
	}


}
