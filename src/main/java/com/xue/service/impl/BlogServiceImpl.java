package com.xue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xue.mapper.TbBlogMapper;
import com.xue.pojo.TbBlog;
import com.xue.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	private TbBlogMapper tbBlogMapper;
	
	@Override
	public List<TbBlog> queryTitleAndStatusAndCreateTime() {

		List<TbBlog> list = tbBlogMapper.selStatusAndTitleAndCreatetime();
		
		return list;
	}

}
