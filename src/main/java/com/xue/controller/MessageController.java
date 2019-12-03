package com.xue.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.xue.pojo.TbLink;
import com.xue.pojo.TbMessage;
import com.xue.result.Result;
import com.xue.service.MessageService;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageServiceImpl;
	
	@GetMapping("showMessages")
	@ResponseBody
	public Result getMessages(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="5")int rows){
	 Result result = messageServiceImpl.listMessage(page,rows);
	 return result;
	}
	
	@PostMapping("postComment")
	public String postComment(String author,String comment,int imageId){
		System.out.println(author+":::::"+comment+"::::");
		TbMessage tbMessage=new TbMessage();
		tbMessage.setAurthor(author);
		tbMessage.setComments(comment);
		tbMessage.setCreatetime(new Date());
		tbMessage.setImagesId(imageId);
		try {
			messageServiceImpl.insertComments(tbMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return "redirect:gustbook";
	}
	
	
	@PostMapping("replyComment")
	@ResponseBody
	public Object replyComment(int id){
		List<TbMessage> list = messageServiceImpl.selByAid(id);
		return list;
	}
	
	@PostMapping("getLinkList")
	@ResponseBody
	public List<TbLink> getLinkList(){
		return this.messageServiceImpl.selAllLink();
	}
	
	
}
