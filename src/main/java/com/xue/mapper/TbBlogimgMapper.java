package com.xue.mapper;

import com.xue.pojo.TbBlogimg;

import org.apache.ibatis.annotations.Select;

public interface TbBlogimgMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(TbBlogimg record);

    int insertSelective(TbBlogimg record);


    TbBlogimg selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(TbBlogimg record);

    int updateByPrimaryKey(TbBlogimg record);
    
    @Select("select * from tb_blogimg where b_id=#{0} order by id desc")
    TbBlogimg getOne(int index);
    
}