package com.xue.mapper;

import com.xue.pojo.TbReviews;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TbReviewsMapper {


    int deleteByPrimaryKey(Integer id);

    @Insert("insert into tb_reviews values(default,#{record.annoyname},#{record.context},#{record.createtime},#{record.bId})")
    int insert(@Param("record")TbReviews record);

    int insertSelective(TbReviews record);

    @Select("select * from tb_reviews where b_id=#{0}")
    List<TbReviews> selectByExample(int bid);

    TbReviews selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(TbReviews record);

    int updateByPrimaryKey(TbReviews record);
    
    @Select("SELECT * FROM tb_reviews WHERE b_id=#{0} ORDER BY createtime asc")
    List<TbReviews> selectByBidDesc(int id);
    
    TbReviews selByAnnoyNmae(String annoyname);
    
}