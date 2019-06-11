package com.controller;

import com.pojo.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.List;

@Controller
@RequestMapping("/account")
@SessionAttributes(names = {"student_id","aid","path"})
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/delete/{aid}")
    public String deleteAccount(@PathVariable("aid")int aid){
        accountService.DeleteAccountByAid(aid);
        return "redirect:/account/findAllAccount";
    }
    @RequestMapping("/transfor")
    public String transfor(int fromid,double money,ModelMap modelMap){
        int sourceid= (int) modelMap.get("aid");
        accountService.Transfor(sourceid,fromid,money);
        return "ok";
    }

    @RequestMapping("/createAccount")
    public String createAccount(ModelMap model){
        System.out.println( model.get("student_id"));
        int sid= (int) model.get("student_id");
        System.out.println(sid);
        Account account=new Account();
        account.setSid(sid);
        account.setMoney(0);
        accountService.SaveAccount(account);
        return "redirect:findAllAccount";
    }
    @RequestMapping("/findById/{aid}")
    public String findById(@PathVariable("aid")int aid, ModelMap model){
        Account account=accountService.findById(aid);
        model.addAttribute("account",account);
        model.addAttribute("aid",aid);
        return "accountpage";
    }

    @RequestMapping("/findAllAccount")
    public String findAllAccount(ModelMap model,@SessionAttribute("student_id") int student_id){
        List<Account> accounts=accountService.findByStudent_Id(student_id);
        model.addAttribute("accounts",accounts);
        return "listAccountAll";
    }
    @RequestMapping("/recharge")
    public String recharge(double money,ModelMap modelMap){
        int aid= (int) modelMap.get("aid");
        Account account= accountService.findById(aid);
        account.setMoney(account.getMoney()+money);
        account.setAccount_id(aid);
        accountService.UpdateAccount(account,true,money);
        return "ok";
    }
    @RequestMapping("/consume/{value}")
    public String consume(@PathVariable(name="value")double value,ModelMap modelMap){
        int aid= (int) modelMap.get("aid");
        Account account= accountService.findById(aid);
        account.setMoney(account.getMoney()-value);
        account.setAccount_id(aid);
        accountService.UpdateAccount(account,false,value);
        return "ok";
    }

}
