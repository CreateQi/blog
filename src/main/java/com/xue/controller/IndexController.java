package com.xue.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xue.result.Result;
import com.xue.service.IndexService;

@Controller
@ResponseBody
public class IndexController {

	@Autowired
	private IndexService indexServiceImpl;
	
	@GetMapping("showindex")
	public Result getData(@RequestParam(defaultValue="1")int page){
		return indexServiceImpl.getBlogList(page,4);
	}
	
}
