package com.xue.service;

import java.util.List;

import com.xue.pojo.TbBlog;

public interface BlogService {

	List<TbBlog> queryTitleAndStatusAndCreateTime();
	
}
