package com.forest.controller;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.UserService;

@Controller
public class UserAction {

    private static final Logger log = LoggerFactory.getLogger(UserAction.class);

    @Autowired
    UserService userService;
    
    @Autowired
    HashedCredentialsMatcher hashedCredentialsMatcher;
	
    /*@RequestMapping("/register")
    public String register(String username, String password){
    	log.info("register：" + username + " - " + password);
    	
        userService.register(username, password);
        return "注册成功";
    }

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(String username, String password){
    	log.info("login：" + username + " - " + password);
    	
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            log.info("登录成功");
            return "redirect:/finduser";
        }catch (Exception e) {
            e.printStackTrace();
        }
        log.info("登录失败！");
        return "redirect:/find";
    }*/

    @RequestMapping("add")
    @RequiresPermissions("add")
    @ResponseBody
    public String add(){
        return "add方法执行.......";
    }

    @RequestMapping("select")
    @RequiresPermissions("select")
    @ResponseBody
    public String select(){
        return "select方法执行.......";
    }

    @RequestMapping("update")
    @RequiresPermissions("update")
    @ResponseBody
    public String update(){
        return "update方法执行.......";
    }
    
    @RequestMapping("unauth")
    public String unauth(){
    	log.debug("UserAction - unauth");
        //return "****************你没权限****************";
        return "redirect:/finderror";
    }
    
    @RequestMapping("ourerror")
    @ResponseBody
    public String ourerror(){
    	log.debug("UserAction - ourerror");
        return "****************  系统错误！error ！ ****************";
    }
    
}
