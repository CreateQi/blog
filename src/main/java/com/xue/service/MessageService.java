package com.xue.service;


import java.util.List;

import com.xue.pojo.TbLink;
import com.xue.pojo.TbMessage;
import com.xue.result.Result;

public interface MessageService {

	Result listMessage(int page,int rows);
	
	int insertComments(TbMessage tbMessage) throws Exception;
	
	List<TbMessage> selByAid(int id);
	
	List<TbLink> selAllLink();
	
}
