package com.controller;
import com.pojo.Student;
import com.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/student")
@SessionAttributes(names = {"student_id","path"})
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/delete/{sid}")
    public String delete(@PathVariable("sid") int sid){
        studentService.DeleteStudent(sid);
        return "redirect:/student/findAll";
    }

    @RequestMapping("/register")
    public String register(String name,int age,String sex,String birthday) throws ParseException {
        System.out.println(name+" "+age+" "+sex+" "+birthday);
        Student student=new Student();
        student.setSex(sex.charAt(0));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf.parse(birthday);
        student.setName(name);
        student.setAge(age);
        student.setBirthday(date);
        studentService.SaveStudent(student);
        student=studentService.findByName(name);
        int id=student.getStudent_id();
        return "redirect:findById/"+id;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Student>students=studentService.findAllStudent();
        modelAndView.addObject("students",students);
        modelAndView.setViewName("listStudentAll");
        return modelAndView;
    }

    @RequestMapping("/findByname")
    public String findByname(Model model, String name){
        Student student=studentService.findByName(name);
        model.addAttribute("student_id",student.getStudent_id());
        return "redirect:/account/findAllAccount";
    }

    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable(name = "id") int id,Model model){
        model.addAttribute("student_id",id);
        System.out.println("ok");
        return "redirect:/account/findAllAccount";
    }

    @ModelAttribute
    public void setRealPath(Model model, HttpServletRequest request){
        String path=request.getContextPath();
        model.addAttribute("path",path);
    }

}
