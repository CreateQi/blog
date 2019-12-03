package com.xue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xue.mapper.TbBlogMapper;
import com.xue.mapper.TbBlogimgMapper;
import com.xue.mapper.TbReviewsMapper;
import com.xue.pojo.TbBlog;
import com.xue.pojo.TbBlogimg;
import com.xue.pojo.TbReviews;
import com.xue.result.Result;
import com.xue.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService{

	@Autowired
	private TbBlogMapper tbBlogMapper;
	
	@Autowired
	private TbReviewsMapper tbReviewsMapper;
	
	@Autowired
	private TbBlogimgMapper tbBlogimgMapper;
	
	@Override
	public Result getBlogList(int page,int rows) {
		
		Result result=new Result();
		
		//定义分页条件
		PageHelper.startPage(page, rows);
		
		List<TbBlog> list = tbBlogMapper.selectByExampleWithBLOBs();
		for (TbBlog tbBlog : list) {
			String string = tbBlog.getContext();
			int length = string.length();
			int indexOf = string.indexOf("<img");
			String subContext=null;
			if(indexOf!=-1){
				subContext=string.substring(0, indexOf/2)+".....";
			}else{
				if(length<20)
				{
					subContext=string.substring(0, length-1);
				}else if(length>=20){
					subContext=string.substring(0, 19)+".......";
				}
				
			}
			tbBlog.setContext(subContext);
			List<TbReviews> res = tbReviewsMapper.selectByBidDesc(tbBlog.getId());
			if(res!=null){
				tbBlog.setCommentNums(res.size());
			}else{
				tbBlog.setCommentNums(0);
			}
			TbBlogimg one = tbBlogimgMapper.getOne(tbBlog.getId());
			if(one!=null){
				tbBlog.setImgurl(one.getImgurl());	
			}
		}
		
		PageInfo<TbBlog> info=new PageInfo<>(list);
		
		result.setData(info.getList());
		result.setTotal(list.size());
		result.setPageNum(info.getPages());
		return result;
	}

	
	//更新阅读人数
	@Override
	public void updateReaders(TbBlog tbBolg){
	  this.tbBlogMapper.updateByPrimaryKeySelective(tbBolg);
	}
	
}
