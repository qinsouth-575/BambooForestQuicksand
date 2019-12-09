package com.forest.config;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.forest.biz.UserService;
import com.forest.entity.Jurisdiction;
import com.forest.entity.Position;
import com.forest.entity.Staff;

@Component
public class UserRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authtoken) throws AuthenticationException {
        logger.info("===================================doGetAuthenticationInfo===进入用户登录");
        
        UsernamePasswordToken token = (UsernamePasswordToken) authtoken;

        Staff user = userService.findUserByName(token.getUsername());
        if (user==null){
            logger.info("账号不存在！");
            throw new UnknownAccountException("账号不存在！");
        }
        logger.info("登录用户：" + user);
        
        //获取用户输入密码
        String oringnPassword = new String((char[]) token.getCredentials());
        String salt = user.getSalt();
        logger.info("用户名："+token.getUsername()+"===="+"密码："+oringnPassword);
        
        //将用户输入的密码加密
        String encodedPassword =  new SimpleHash("MD5",oringnPassword,salt,3).toString();
        
        //比对用户输入密码与数据库密码
        if (!encodedPassword.equals(user.getPassword())){
            logger.info("密码错误！");
            throw new AccountException("密码错误！");
        }

        //自定义的认证信息  在登录时也要提供
        return new SimpleAuthenticationInfo(user.getJobNumber(),oringnPassword,ByteSource.Util.bytes(salt),getName());

    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("====================================doGetAuthorizationInfo===进入用户授权");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        
        //登录用户名
        String name = (String) principals.getPrimaryPrincipal();
        logger.info("登录用户名：" + name);
        Staff user = userService.findUserByName(name);
        logger.info("登录用户：" + user);
        
        //角色信息导入shiro
        List<Position> roles = userService.getRoleByUserId(user.getStaffId());
        logger.info("登录用户所含角色信息集合：" + roles);
        Set<String> roleNames = roles.stream().map(Position::getDescription).collect(Collectors.toSet());
        //Set<String> roleNames = roles.stream().map(Position::getRole).collect(Collectors.toSet());
        simpleAuthorizationInfo.setRoles(roleNames);
        logger.info("登录用户角色名集合 ："+roleNames);
        
        //权限信息导入shiro
        List<Jurisdiction> permissions = userService.getPermissionByUserId(user.getStaffId());
        logger.info("登录用户权限集合 ："+roleNames);
        Set<String> permissionNames = permissions.stream().map(Jurisdiction::getJurName).collect(Collectors.toSet());
        simpleAuthorizationInfo.setStringPermissions(permissionNames);
        logger.info("登录用户权限 ："+permissionNames);
        
        return simpleAuthorizationInfo;
    }
    
}
