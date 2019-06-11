package com.service;

import com.pojo.Account;

import java.util.List;

public interface AccountService {
    List<Account> findByStudent_Id(int sid);
    Account findById(int aid);
    void SaveAccount(Account account);
    void UpdateAccount(Account account,boolean flag,double money);
    void DeleteAccount(int sid);
    void Transfor(int soruceAid,int fromAid,double money);
    void DeleteAccountByAid(int aid);
}
