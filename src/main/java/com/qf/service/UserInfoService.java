package com.qf.service;

import com.qf.dto.RoleDto;
import com.qf.pojo.UserInfo;
import com.qf.vo.UserInfoVo;

import java.util.List;

/**
 * Created by DELL on 2019/5/16.
 */
public interface UserInfoService {

    public UserInfo userLogin(UserInfoVo userInfoVo);

    public int updateUserInfoById(UserInfo userInfo);

    public boolean addUserInfo(UserInfo userInfo);

    public List<UserInfo> listAllUserInfo();

    public UserInfo getUserInfoById(int userId);

    public List<RoleDto> listRoleDtoByUserId(int userId);
}
