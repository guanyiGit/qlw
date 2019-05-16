package com.soholy.dogmanager.service.findpetnotice.impl;

import com.soholy.dogmanager.entity.TMissDog;
import com.soholy.dogmanager.mapper.findpetnotice.FindPetMapper;
import com.soholy.dogmanager.service.findpetnotice.FindPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linchong
 * @create 2019-05-15 13:38
 */
@Service
public class FindPetServiceImpl implements FindPetService {
    @Autowired
    private FindPetMapper findPetMapper;

    @Override
    public Integer addNotice(TMissDog tMissDog) {
        return findPetMapper.insertNotice(tMissDog);
    }
}
