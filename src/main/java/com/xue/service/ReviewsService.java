package com.xue.service;

import java.util.List;

import com.xue.pojo.TbReviews;
import com.xue.result.Result;

public interface ReviewsService {

	Result getListReviews(int bid);
	
	int inserReviews(TbReviews resviews)  throws Exception ;
	
	int isRepeat(String annoyname);
	
	
}
