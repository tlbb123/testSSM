package com.mapper;

import com.pojo.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountMapper {
    @Results(id = "accountMapper",value = {
            @Result(id=true,column = "account_id",property = "account_id"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "money",property = "money"),
            @Result(column = "account_id",property = "infos",many = @Many(select = "com.mapper.InfoMapper.findById",fetchType = FetchType.LAZY)),
            @Result(column = "sid",property = "student", one = @One(select = "com.mapper.StudentMapper.findById",fetchType = FetchType.EAGER)),
            })

    @Select("select * from account where sid=#{sid}")
    List<Account> findByStudent_Id(int sid);

    @Select("select * from account where account_id=#{aid}")
    Account findById(int aid);

    @Insert("insert into account(sid,money) values(#{sid},#{money}) ")
    void SaveAccount(Account account);

    @Update("update account set money=#{money} where account_id=#{account_id}")
    void UpdateAccount(Account account);

    @Delete("delete  from account where sid=#{sid}")
    void DeleteAccount(int sid);

    @Delete("delete  from account where account_id=#{account_id}")
    void DeleteAccountByAid(int account_id);

}
