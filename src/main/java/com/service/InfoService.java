package com.service;

import com.pojo.Info;

import java.util.List;

public interface InfoService {
    List<Info> findById(int aid);
    void SaveInfo(Info info);
    void UpdateInfo(Info info);
    void DeleteInfo(int aid);
}
