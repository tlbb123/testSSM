package com.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        MyException exception=null;
        if(e instanceof MyException)
            exception= (MyException) e;
        else
            exception=new MyException("出现了未知的问题，请刷新页面");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("exception",exception.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
