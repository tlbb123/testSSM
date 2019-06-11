package com.service.Impl;

import com.mapper.AccountMapper;
import com.mapper.InfoMapper;
import com.pojo.Account;
import com.pojo.Info;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private InfoMapper infoMapper;
    
    @Override
    public List<Account> findByStudent_Id(int sid) {
        return accountMapper.findByStudent_Id(sid);
    }

    @Override
    public Account findById(int aid) {
        return accountMapper.findById(aid);
    }

    @Override
    public void SaveAccount(Account account) {
        accountMapper.SaveAccount(account);
    }


    @Override
    public void UpdateAccount(Account account,boolean flag,double money) {
        Info info=new Info();
        info.setAid(account.getAccount_id());
        if (flag)
            info.setInfo_change("充值"+money);
        else
            info.setInfo_change("消费"+money);
        accountMapper.UpdateAccount(account);
        info.setDate(new Date());
        infoMapper.SaveInfo(info);
    }


    @Override
    public void DeleteAccount(int sid) {
        List<Account>accounts=accountMapper.findByStudent_Id(sid);
        for(Account account:accounts)
            infoMapper.DeleteInfo(account.getAccount_id());
        accountMapper.DeleteAccount(sid);
    }


    @Override
    public void Transfor(int sourceAid, int fromAid,double money) {
        Account sourceAcconut=accountMapper.findById(sourceAid);
        Account fromAccount=accountMapper.findById(fromAid);
        sourceAcconut.setMoney(sourceAcconut.getMoney()-money);
        fromAccount.setMoney(fromAccount.getMoney()+money);
        accountMapper.UpdateAccount(sourceAcconut);
        accountMapper.UpdateAccount(fromAccount);
        Info info=new Info();
        info.setAid(sourceAid);
        info.setDate(new Date());
        info.setInfo_change("向"+fromAid+"转账"+money);
        infoMapper.SaveInfo(info);
        info.setAid(fromAid);
        info.setInfo_change("从"+sourceAid+"得到"+money);
        infoMapper.SaveInfo(info);
    }

    @Override
    public void DeleteAccountByAid(int aid) {
        infoMapper.DeleteInfo(aid);
        accountMapper.DeleteAccountByAid(aid);
    }
}
