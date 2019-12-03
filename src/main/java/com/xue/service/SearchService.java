package com.xue.service;

import java.util.List;

import com.xue.pojo.TbBlog;

public interface SearchService {

	List<TbBlog> selectLikeTitle(String searchInner);
	
}
