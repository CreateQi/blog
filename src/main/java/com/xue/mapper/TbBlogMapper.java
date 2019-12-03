package com.xue.mapper;

import com.xue.pojo.TbBlog;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbBlogMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(TbBlog record);

    int insertSelective(TbBlog record);

    @Select("select * from tb_blog where status=1")
    List<TbBlog> selectByExampleWithBLOBs();


    @Select("select * from tb_blog where id=#{0}")
    TbBlog selectByPrimaryKey(int id);




    @Update("update tb_blog set visits=#{tbBolg.visits} where id=#{tbBolg.id}")
    int updateByPrimaryKeySelective(@Param("tbBolg")TbBlog tbBolg);

    int updateByPrimaryKeyWithBLOBs(TbBlog record);

    int updateByPrimaryKey(TbBlog record);
    
    @Select(" select title,id,createtime,status from tb_blog order by createtime DESC")
     List<TbBlog> selStatusAndTitleAndCreatetime();
    
    @Select("select * from tb_blog where status=1 and (title like CONCAT('%',#{searchInner},'%') or context like CONCAT('%',#{searchInner},'%'))")
     List<TbBlog> selectLike(@Param("searchInner")String searchInner);
    
}