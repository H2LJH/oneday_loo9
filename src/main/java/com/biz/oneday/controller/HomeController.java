package com.biz.oneday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */

@RequiredArgsConstructor
@Controller
public class HomeController
{

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String home() 
	{

		return "home";
	}

}
