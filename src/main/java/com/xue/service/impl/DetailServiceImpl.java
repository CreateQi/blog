package com.xue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xue.mapper.TbBlogMapper;
import com.xue.mapper.TbReviewsMapper;
import com.xue.pojo.TbBlog;
import com.xue.pojo.TbReviews;
import com.xue.service.DetailService;

@Service
public class DetailServiceImpl implements DetailService{

	@Autowired
	private TbBlogMapper tbBlogMapper;
	
	@Autowired
	private TbReviewsMapper tbReviewsMapper;
	
	@Override
	public TbBlog getBlog(int id) {
		TbBlog tbBlog = tbBlogMapper.selectByPrimaryKey(id);
		List<TbReviews> res = tbReviewsMapper.selectByExample(id);
		if(res==null){
			tbBlog.setCommentNums(0);
			tbBlog.setReviews(null);
		}else
		{
			tbBlog.setReviews(res);
			tbBlog.setCommentNums(res.size());
		}
		return tbBlog;
		
	}

}
