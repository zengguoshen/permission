package com.qf.service;

import com.qf.dto.RoleDto;
import com.qf.vo.RoleInfoVo;

import java.util.List;

/**
 * Created by DELL on 2019/5/21.
 */
public interface RoleInfoService {

    public List<RoleDto> getAllRoleBy(RoleInfoVo roleInfoVo);
}
