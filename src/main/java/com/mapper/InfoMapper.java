package com.mapper;

import com.pojo.Info;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InfoMapper {

    @Results(id="infoMapper",value = {
            @Result(id = true,column = "info_id",property = "info_id"),
            @Result(column = "date",property = "date"),
            @Result(column = "aid",property = "aid"),
            @Result(column = "info_change",property = "info_change"),
            @Result(property = "account",column = "aid",one = @One(select = "com.mapper.AccountMapper.findById",fetchType = FetchType.EAGER))
    })

    @Select("select * from info where aid=#{aid}")
    List<Info> findById(int aid);

    @Insert("insert into info(date,aid,info_change) values (#{date},#{aid},#{info_change}) ")
    void SaveInfo(Info info);

    @Update("update info set date=#{date},info_change=#{info_change} where info_id=#{info_id}")
    void UpdateInfo(Info info);

    @Delete("delete from info where aid=#{aid}")
    void DeleteInfo(int aid);
}
