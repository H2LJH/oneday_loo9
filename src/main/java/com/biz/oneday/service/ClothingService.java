package com.biz.oneday.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.biz.oneday.dto.ClothingVO;

public interface ClothingService extends GenericService<ClothingVO, Long>
{
	public List<ClothingVO> findByUserList(HttpServletRequest req);
	public List<ClothingVO> findByDetailList(String io_pname, HttpServletRequest req);
	
	public int insert(ClothingVO vo, HttpServletRequest req);
	public int selected_delete(String[] pk);
}
