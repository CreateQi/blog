package com.xue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping(value="index")
	public String index(){
		return "index";
	}
	
	
	@GetMapping("detail")
	public String detail(){
		return "detail";
	}
	
	
	@GetMapping("update")
	public String update(){
		return "update";
	}
	
	@GetMapping("link")
	public String link(){
		return "link";
	}
	
	@GetMapping("gustbook")
	public String gustbook(){
		return "gustbook";
	}
	
	@GetMapping("search")
	public String search(){
		return "search";
	}
	
}
