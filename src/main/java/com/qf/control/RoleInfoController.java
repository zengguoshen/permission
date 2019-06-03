package com.qf.control;

import com.qf.service.RoleInfoService;
import com.qf.vo.RoleInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DELL on 2019/5/21.
 */
@RestController
public class RoleInfoController {

    @Autowired
    RoleInfoService roleInfoService;


    @RequestMapping("/getAllRoleBy")
    public Object getAllRoleBy(@RequestBody RoleInfoVo roleInfoVo){
        //根据VO查询并返回
        return roleInfoService.getAllRoleBy(roleInfoVo);
    }
}
