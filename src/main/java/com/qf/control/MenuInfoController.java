package com.qf.control;

import com.qf.dto.MenuInfoDto;
import com.qf.pojo.UserInfo;
import com.qf.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2019/5/21.
 */
@RestController
public class MenuInfoController {

    @Autowired
    MenuInfoService menuInfoService;

    @RequestMapping("getAllMenuInfo")
    public Object getAllMenuInfo(@RequestParam int roleId){
        List<MenuInfoDto> menuInfoDtoArrayList = menuInfoService.listMenu(roleId);

//        MenuInfoDto parentMenu1 = new MenuInfoDto();
//        parentMenu1.setId(1);
//        parentMenu1.setName("父菜单1");
//        parentMenu1.setPid(0);
//        parentMenu1.setSeqno(1);
//        parentMenu1.setUrl("");
//        ArrayList<MenuInfoDto> children = new ArrayList<MenuInfoDto>();
//        MenuInfoDto childOne = new MenuInfoDto();
//        childOne.setId(2);
//        childOne.setName("子菜单1");
//        childOne.setPid(1);
//        childOne.setSeqno(2);
//        childOne.setUrl("aaa.html");
//        MenuInfoDto childTwo = new MenuInfoDto();
//        childTwo.setId(2);
//        childTwo.setName("子菜单2");
//        childTwo.setPid(1);
//        childTwo.setSeqno(2);
//        childTwo.setUrl("aaa.html");
//        MenuInfoDto childThree = new MenuInfoDto();
//        childThree.setId(2);
//        childThree.setName("子菜单3");
//        childThree.setPid(1);
//        childThree.setSeqno(2);
//        childThree.setUrl("aaa.html");
//
//        children.add(childOne);
//        children.add(childTwo);
//        children.add(childThree);
//        parentMenu1.setChildren(children);
//
//
//        menuInfoDtoArrayList.add(parentMenu1);
        return menuInfoDtoArrayList;
    }


    @RequestMapping("listMenuInfoByUserId")
    public Object listMenuInfoByUserId(HttpSession httpSession){

        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        int userId = userInfo.getUserId();
        return this.menuInfoService.listMenuByUserId(userId);
    }


}
