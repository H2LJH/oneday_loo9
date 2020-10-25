package com.biz.oneday.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.oneday.dto.UserVO;


@Service("UserServiceV2")
public class UserV2 extends UserV1 
{

	@Override
	public boolean checkByUser(UserVO vo, int check) 
	{
		UserVO reqVO = vo;
		List<UserVO> userList = selectAll();			
		String[] strCheck = new String[] {reqVO.getU_id(), reqVO.getU_pwd()};
			
		if(userList.size() == 0)
			return true;
			
		switch (check) {
		case -1:
			for(int i= 0; i < strCheck.length; ++i) // 공백 널값 체크
			{
				strCheck[i] = strCheck[i].trim();
				if(strCheck[i].isEmpty())
				{
					System.out.println("공백 널값 들어감");
					return false;
				}
			}

		case 1: // 아이디 중복 체크
			for(int i= 0; i < userList.size(); ++i)
				if(userList.get(i).getU_id().equals(reqVO.getU_id()) == true) 
					{
						System.out.println("아이디 중복 있음");
						return false;
					}
			
		case 2: // 로그인 체크
			for(int i= 0; i < userList.size(); ++i)
				if(userList.get(i).getU_id().equals(reqVO.getU_id()) && userList.get(i).getU_pwd().equals(reqVO.getU_pwd())) 
					 {
						System.out.println("아이디 로그인 성공");
						return true;
					 }
		}
		return true;
	}	

}
