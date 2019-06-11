package com.service.Impl;
import com.mapper.InfoMapper;
import com.pojo.Info;
import com.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;
    @Override
    public List<Info> findById(int aid) {
        return infoMapper.findById(aid);
    }

    @Override
    public void SaveInfo(Info info) {
            infoMapper.SaveInfo(info);
    }

    @Override
    public void UpdateInfo(Info info) {
            infoMapper.UpdateInfo(info);
    }

    @Override
    public void DeleteInfo(int aid) {
        infoMapper.DeleteInfo(aid);
    }

}
