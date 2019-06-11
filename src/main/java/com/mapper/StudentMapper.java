package com.mapper;


import com.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper {

    @Results(id = "studentMapper",value = {
            @Result(id = true,column = "student_id",property = "student_id"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column="student_id",property = "accounts",many = @Many(select="com.mapper.AccountMapper.findByStudent_Id",fetchType = FetchType.LAZY)),
    })
    @Select("select * from student")
    List<Student> findAllStudent();

    @Select({"select * from student where name=#{name}"})
    Student findByName(String name);

    @Select({"select * from student where student_id=#{student_id}"})
    Student findById(int student_id);

    @Insert("insert into student(name,age,sex,birthday) values(#{name},#{age},#{sex},#{birthday}) ")
    void SaveStudent(Student student);

    @Update("update student set name=#{name},age=#{age},sex=#{sex},birthday=#{birthday} where student_id=#{student_id}")
    void UpdateStudent(Student student);

    @Delete("delete from student where student_id=#{student_id}")
    void DeleteStudent(int student_id);
}
