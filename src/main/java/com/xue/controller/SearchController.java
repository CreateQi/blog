package com.xue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xue.pojo.TbBlog;
import com.xue.service.SearchService;

@Controller
@ResponseBody
public class SearchController {

	@Autowired
	private SearchService earchServiceImpl;
	
	@RequestMapping("searchBlog")
	public List<TbBlog> showSearchResult(String searchInner){
		System.out.println("搜索内容为"+searchInner);
		return earchServiceImpl.selectLikeTitle(searchInner);
	}
	
}
