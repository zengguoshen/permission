package com.qf;

import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import com.qf.service.impl.UserInfoServiceImpl;
import com.qf.vo.UserInfoVo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DELL on 2019/5/16.
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
        UserInfoService userInfoService = context.getBean(UserInfoService.class);
//        UserInfoVo userInfoVo = new UserInfoVo();
//        userInfoVo.setUserName("zhangzhantu");
//        userInfoVo.setPassword("123456");

//        boolean flag = userInfoService.userLogin(userInfoVo);
//        System.out.println(flag);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1);
        userInfo.setUserName("图图=秃秃");
        userInfo.setPassword("654321");
        int count = userInfoService.updateUserInfoById(userInfo);
        System.out.println(count);
    }
}
