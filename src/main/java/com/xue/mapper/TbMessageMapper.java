package com.xue.mapper;

import com.xue.pojo.TbMessage;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TbMessageMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(TbMessage record);

    @Insert("insert into tb_message values(default,#{record.aurthor},#{record.comments},default,default,#{record.imagesid},#{record.createtime})")
    int insertSelective(@Param("record")TbMessage record);

    @Select("select * from tb_message where status=1 and a_id=#{0} order by createtime desc")
    List<TbMessage> selectByExample(int aid);

    TbMessage selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(TbMessage record);

    int updateByPrimaryKey(TbMessage record);
    
    
}