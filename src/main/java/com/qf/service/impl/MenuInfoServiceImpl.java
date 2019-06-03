package com.qf.service.impl;

import com.qf.dto.MenuInfoDto;
import com.qf.mapper.MenuInfoMapper;
import com.qf.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 2019/5/21.
 */
@Service
public class MenuInfoServiceImpl implements MenuInfoService{
    @Autowired
    MenuInfoMapper menuInfoMapper;

    public List<MenuInfoDto> listMenu(int roleId) {
        return menuInfoMapper.listMenu(roleId);
    }

    public List<MenuInfoDto> listMenuByUserId(int userId) {
        return menuInfoMapper.listMenuByUserId(userId);
    }
}
