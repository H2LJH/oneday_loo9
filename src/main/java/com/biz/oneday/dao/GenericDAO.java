package com.biz.oneday.dao;

import java.util.List;

public interface GenericDAO<VO, PK>
{
	public List<VO> selectAll();
	
	public VO findByRecord(PK seq);
	public List<VO> findByCardiality1231231(PK id);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);
}
