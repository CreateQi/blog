package com.xue.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xue.pojo.TbBlog;
import com.xue.pojo.TbReviews;
import com.xue.result.Result;
import com.xue.service.DetailService;
import com.xue.service.IndexService;
import com.xue.service.ReviewsService;

@Controller
@ResponseBody
public class DetailController {

	@Autowired
	private DetailService detailServiceImpl;
	
	@Autowired
	private ReviewsService reviewsServiceImpl;
	
	@Autowired
	private IndexService indexServiceImpl;
	
	@PostMapping("showDetail")
	public Object getDetailBlog(int bid){
		System.out.println("博客id"+bid);
		TbBlog blog = detailServiceImpl.getBlog(bid);
		blog.setVisits(blog.getVisits()+1);
		this.indexServiceImpl.updateReaders(blog);
		return blog;
	}
	
	@PostMapping("insertComment")
	public Result insertComment(int bid,String annoyname,String context){
		System.out.println(bid+":::"+annoyname+":::"+context);
	Result result=new Result();     
	//添加
	TbReviews reviews=new TbReviews();
	reviews.setAnnoyname(annoyname);
	reviews.setContext(context);
	reviews.setbId(bid);
	reviews.setCreatetime(new Date());
	
	try {
		int index = this.reviewsServiceImpl.inserReviews(reviews);
		if(index>0){
			result.setStatus(0);
		}
	} catch (Exception e) {
		e.printStackTrace();
		result.setStatus(400);
	}
	return result;
	}
	
}
