package com.xue.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xue.mapper.TbReviewsMapper;
import com.xue.pojo.TbReviews;
import com.xue.result.Result;
import com.xue.service.ReviewsService;

@Service
public class ReviewsServiceImpl implements ReviewsService{

	Logger log=LoggerFactory.getLogger(ReviewsServiceImpl.class);
	
	@Autowired
	private TbReviewsMapper tbReviewsMapper;
	
	@Override
	public Result getListReviews(int bid) {
		Result result=new Result();
		List<TbReviews> list = tbReviewsMapper.selectByExample(bid);
		
		result.setTotal(list.size());
		result.setData(list);
		return result;
	}
	
	@Override
	public int isRepeat(String annoyname){
		TbReviews name = tbReviewsMapper.selByAnnoyNmae(annoyname);
		if(name!=null)
		{
			return 1;
		}else
		{
			return 0;
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int inserReviews(TbReviews resviews) throws Exception {
		//开始添加评论信息
		log.info(resviews.toString());
		int index = tbReviewsMapper.insert(resviews);
		if(index==1)
		{
			log.info("添加成功");
			return index;
		}else
		{
			log.info("添加失败");
			throw new Exception("添加失败");
		}
	}

}
