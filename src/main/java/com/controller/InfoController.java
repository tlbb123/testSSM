package com.controller;

import com.pojo.Info;
import com.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/info")
public class InfoController {
    @Autowired
    InfoService infoService;
    @RequestMapping("/showInfo")
public String showInfo(@SessionAttribute("aid") int aid, ModelMap modelMap){
        List<Info>infos=infoService.findById(aid);
        modelMap.addAttribute("infos",infos);
        return "showInfo";
}
}
