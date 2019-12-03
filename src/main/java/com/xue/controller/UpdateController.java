package com.xue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xue.pojo.TbBlog;
import com.xue.service.BlogService;

@Controller
@ResponseBody
public class UpdateController {

	@Autowired
	private BlogService blogServiceImpl;
	
	
	@GetMapping("showupdate")
	public Object showUpdate(){
		
		List<TbBlog> list = blogServiceImpl.queryTitleAndStatusAndCreateTime();
		
		return list;
	}
	
}
