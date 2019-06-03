package com.qf.control;

import com.qf.pojo.UserInfo;
import com.qf.service.UserInfoService;
import com.qf.vo.TestValidationVo;
import com.qf.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by DELL on 2019/5/17.
 */

//声明这个类是一个控制器，这样它就能被扫描到
@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @ResponseBody
    @RequestMapping("loginController")
    public Object login(@RequestBody UserInfoVo userInfoVo,HttpSession httpSession){
        System.out.println("hello world"+userInfoVo.getUserName()+":"+userInfoVo.getPassword());
        UserInfo userInfo = userInfoService.userLogin(userInfoVo);
        if(userInfo!=null)
        {
            System.out.println("登录成功");

            //制造一个令牌，并保存到session中
            httpSession.setAttribute("userInfo",userInfo);
            return true;
        }else{
            System.out.println("登录失败");
            return false;
        }
    }

    //传统开发模式
    @ResponseBody
    @RequestMapping("register")
    public String registerUserInfo(@RequestBody UserInfo userInfo){
        if(userInfoService.addUserInfo(userInfo)){
            System.out.println("注册成功");
            return "true";
        }else{
            System.out.println("注册失败");
            return "false";
        }
    }

    //restful风格开发?后台一个注解搞定
    //后台返回json，前端获取、解析json
    @ResponseBody
    @RequestMapping("listAllUserInfo")
    public Object listAllUserInfo(){
        return userInfoService.listAllUserInfo();
    }

    @ResponseBody
    @RequestMapping("getUserInfoById")
    public Object getUserInfoById(@RequestParam int userId){
        return userInfoService.getUserInfoById(userId);
    }

    @ResponseBody
    @RequestMapping("updateUserInfoById")
    public Object updateUserInfoById(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);

        //调用service的对应方法
        int count = userInfoService.updateUserInfoById(userInfo);
        if(count>0){
            return true;
        }
        return false;
    }

    @ResponseBody
    @RequestMapping("listRoleDto")
    public Object listRoleDto(@RequestParam int userId){
        //如何把dto的数据保存到vo返回?
        //省事、偷懒
        return userInfoService.listRoleDtoByUserId(userId);
    }

    @ResponseBody
    @RequestMapping("/pathVariableTest/{username}-{password}")
    public Object pathVariableTest(@PathVariable("username") String username,@PathVariable("password") String password){
        String returnVal = "username:"+username+"\t"+"password:"+password;
        System.out.println(returnVal);
        return returnVal;
    }


    @ResponseBody
    @RequestMapping("getCookieValue")
    public Object getCookieValue(@CookieValue(value = "name",required = false)String username,@CookieValue(value = "age",required = false)int age){
        System.out.println(username+":"+age);
        return username+":"+age;
    }

    @ResponseBody
    @RequestMapping(value="doRegister",method = RequestMethod.POST)
    public Object doRegister(@Valid @RequestBody
                                     TestValidationVo user, BindingResult result, ModelMap map){
        // 如果入参有问题，返回注册页面
        if (result.hasErrors()) {
            List<FieldError> errorList = result.getFieldErrors();
            for(FieldError error : errorList){
                System.out.println(error.getField() + "*" + error.getDefaultMessage());
                map.put("ERR_" + error.getField(), error.getDefaultMessage());
            }
            return map.toString();
        }
        // 这里省略注册代码...
        return "register_success";
    }


}
