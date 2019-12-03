package com.xue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.xue.pojo.TbLink;

public interface TbLinkMapper {
  
	
	@Select("select id,link,link.link_title  `linkTitle`,link.link_pwd `linkPwd`,link.createtime `createtime` from tb_link link where status=1 order by createtime desc")
	List<TbLink> selectAll();
	
}