package com.xue.service;


import com.xue.pojo.TbBlog;
import com.xue.result.Result;

public interface IndexService {

	Result getBlogList(int page,int rows);

	void updateReaders(TbBlog tbBolg);
	
}
