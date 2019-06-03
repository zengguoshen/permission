package com.qf.service.impl;

import com.qf.dto.RoleDto;
import com.qf.mapper.UserInfoMapper;
import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import com.qf.tool.MD5Utils;
import com.qf.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by DELL on 2019/5/16.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    UserInfoMapper userInfoMapper;
    //如何用返回list的dao方法做判断返回是否登录成功?
    public UserInfo userLogin(UserInfoVo userInfoVo) {
        userInfoVo.setPassword(MD5Utils.myEncode(userInfoVo.getPassword()));
        UserInfo userInfos = userInfoMapper.userLogin(userInfoVo);
        return userInfos;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int updateUserInfoById(UserInfo userInfo) {
        int count = userInfoMapper.updateUserInfoById(userInfo);
        System.out.println(count);
        return count;
    }

    public boolean addUserInfo(UserInfo userInfo) {

        userInfo.setPassword(MD5Utils.myEncode(userInfo.getPassword()));
        int count = userInfoMapper.addUserInfo(userInfo);
        if(count>0){
            return true;
        }
        return false;
    }

    public List<UserInfo> listAllUserInfo() {

        return userInfoMapper.listUserInfo();
    }

    public UserInfo getUserInfoById(int userId) {

        return userInfoMapper.getUserInfoById(userId);
    }

    @Transactional
    public int deleteUserInfoById(UserInfo userInfo){
        int count1 = userInfoMapper.updateUserInfoById(userInfo);
        int count2 = 0;
        //count2 = userInfoMapper.deleteUserInfoById(....);
        return count1+count2;
    }


    public List<RoleDto> listRoleDtoByUserId(int userId){
        return userInfoMapper.listRoleDtoByUserId(userId);
    }
}
