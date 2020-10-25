package com.biz.oneday.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.oneday.dto.ClothingVO;

public interface ClothingDAO extends GenericDAO<ClothingVO, Long>
{
	public List<ClothingVO> findByDetailList(@Param("io_pname")String io_pname, @Param("io_user")String io_user);
	public List<ClothingVO> findByClothingList(String id);
	public int delete(long pk);
}
