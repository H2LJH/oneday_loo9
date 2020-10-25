package com.biz.oneday.service;

import com.biz.oneday.dto.UserVO;

public interface UserService extends GenericService<UserVO, String>
{	
	public boolean checkByUser(UserVO vo, int check);

}
