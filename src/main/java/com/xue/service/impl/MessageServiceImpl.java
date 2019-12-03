package com.xue.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xue.mapper.TbLinkMapper;
import com.xue.mapper.TbMessageMapper;
import com.xue.pojo.TbLink;
import com.xue.pojo.TbMessage;
import com.xue.result.Result;
import com.xue.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	private Logger logger=LoggerFactory.getLogger(MessageServiceImpl.class);
	
	@Autowired
	private TbMessageMapper tbMessageMapper;
	
	@Autowired
	private TbLinkMapper tbLinkMapper;
	
	@Override
	public Result listMessage(int page,int rows) {
		Result result=new Result();
		PageHelper.startPage(page, rows);
		List<TbMessage> messages = tbMessageMapper.selectByExample(0);
		System.out.println(messages);
		PageInfo<TbMessage> info=new PageInfo<>(messages);
		result.setPageNum(info.getPages());
		result.setData(info.getList());
        result.setListSize(info.getTotal());
        System.out.println("总数:"+info.getTotal());
		result.setNowPage(info.getPageNum());
		
		return result;
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
   public int insertComments(TbMessage tbMessage) throws Exception{
		logger.debug("添加评论信息"+tbMessage);
		int index = tbMessageMapper.insertSelective(tbMessage);
		if(index>0){
			logger.info("添加成功");
			return index;
		}else
		{
			logger.info("添加失败");
			throw new Exception("添加失败");
		}
   }	

//	public void addTbMessages(TbMessage tbMessage){
//		TbMessageExample example=new TbMessageExample();
//		example.createCriteria().andStatusEqualTo(1).andAIdEqualTo(tbMessage.getId());
//		List<TbMessage> list = this.tbMessageMapper.selectByExample(example);
//		//给上一级设置二级
//		tbMessage.setTbMessages(list);
//		//寻找下一级
//		for (TbMessage tbMessage2 : list) {
//			addTbMessages(tbMessage2);
//		}
//	}
	
	@Override
	public List<TbMessage> selByAid(int id){
		List<TbMessage> messages = tbMessageMapper.selectByExample(id);
		return messages;
	}

	@Override
	public List<TbLink> selAllLink() {
		List<TbLink> list = tbLinkMapper.selectAll();
		return list;
	}

}
