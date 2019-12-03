package com.xue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xue.mapper.TbBlogMapper;
import com.xue.pojo.TbBlog;
import com.xue.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private TbBlogMapper tbBlogMapper;
	
	@Override
	public List<TbBlog> selectLikeTitle(String searchInner) {
		List<TbBlog> list = tbBlogMapper.selectLike(searchInner);
		for (TbBlog tbBlog : list) {
			String context = tbBlog.getContext();
			int indexOf = context.indexOf(searchInner);
			String substring="";
			if(indexOf==-1)
			{
				substring=context.substring(5, 30);
			}else{
			int length = context.length();
			if(indexOf<(length/2)){
				substring= context.substring(indexOf, length/3+indexOf);
			}else if(indexOf>=(length/2)){
				substring= context.substring(indexOf-length/3, indexOf);
			}
		}
			substring="..."+substring+"...";
			tbBlog.setContext(substring);
		}
		return list;
	}

}
