package com.biz.oneday.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.biz.oneday.service.DateService;

@Component
public class DateIV1 implements DateService 
{
	@Override
	public String[] dateTime() 
	{
		LocalDateTime lDateTime = LocalDateTime.now();
		String strDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(lDateTime);
		String str_Time = DateTimeFormatter.ofPattern("HH:mm:SS").format(lDateTime);
		String[] arrDate = new String[] {strDate, str_Time};
		return arrDate;
	}

}
