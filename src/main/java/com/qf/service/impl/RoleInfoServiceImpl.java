package com.qf.service.impl;
69
import com.qf.dto.RoleDto;
import com.qf.mapper.RoleInfoMapper;
import com.qf.service.RoleInfoService;
import com.qf.vo.RoleInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 2019/5/21.
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService{

    @Autowired
    RoleInfoMapper roleInfoMapper;

    public List<RoleDto> getAllRoleBy(RoleInfoVo roleInfoVo) {
//        roleInfoVo.setRoleName("%"+roleInfoVo.getRoleName()+"%");
//        roleInfoVo.setShortName("%"+roleInf将j'j'j'j'j'j'j'j'j'j'j'j'j'j'j'j'j'j'joVo.getShortName()+"%");
        return roleInfoMapper.getAllRoleBy(roleInfoVo);
    }
}

