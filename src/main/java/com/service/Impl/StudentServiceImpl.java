package com.service.Impl;

import com.mapper.AccountMapper;
import com.mapper.InfoMapper;
import com.mapper.StudentMapper;
import com.pojo.Account;
import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
   private StudentMapper mapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private InfoMapper infoMapper;
    @Override
    public List<Student> findAllStudent() {
        return mapper.findAllStudent();
    }

    @Override
    public Student findByName(String name) {
        return mapper.findByName(name);
    }

    @Override
    public Student findById(int student_id) {
        return mapper.findById(student_id);
    }

    @Override
    public void SaveStudent(Student student) {
        mapper.SaveStudent(student);
    }

    @Override
    public void UpdateStudent(Student student) {
        mapper.UpdateStudent(student);
    }

    @Override
    public void DeleteStudent(int student_id) {
        List<Account>accounts=accountMapper.findByStudent_Id(student_id);
        for(Account account:accounts)
            infoMapper.DeleteInfo(account.getAccount_id());
        accountMapper.DeleteAccount(student_id);
        mapper.DeleteStudent(student_id);
    }
}
