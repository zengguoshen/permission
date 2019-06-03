package com.qf.mapper;

import com.qf.dto.RoleDto;
import com.qf.pojo.UserInfo;
import com.qf.vo.RoleInfoVo;
import com.qf.vo.SplitePageVo;
import com.qf.vo.UserInfoVo;

import java.util.List;

/**
 * Created by DELL on 2019/5/9.
 */
public interface UserInfoMapper {

    public UserInfo userLogin(UserInfoVo userInfoVo);

    public List<UserInfo> listUserInfoBy(UserInfoVo userInfoVo);

    public List<RoleInfoVo> listRoleByUserId(int roleId);

    public List<UserInfo> listUserInfoAndRoleInfo();

    public List<UserInfo> listUserInfoSplitePage(SplitePageVo splitePageVo);

    public int updateUserInfoById(UserInfo userInfo);

    public int addUserInfo(UserInfo userInfo);

    public List<UserInfo> listUserInfo();

    public UserInfo getUserInfoById(int userId);

    public List<RoleDto> listRoleDtoByUserId(int userId);
}
