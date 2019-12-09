package com.forest.biz;

import java.util.List;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.Jurisdiction;
import com.forest.entity.Position;
import com.forest.entity.Staff;
import com.forest.mapper.JurisdictionMapper;
import com.forest.mapper.PositionMapper;
import com.forest.mapper.StaffMapper;

@Service
@Transactional
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private StaffMapper userMapper;

    @Autowired
    private PositionMapper roleMapper;

    @Autowired
    private JurisdictionMapper permissionMapper;
    
    //根据用户id查询所有的角色信息
     public List<Position> getRoleByUserId(Integer id){
        List<Integer> role_ids = userMapper.listRoleIdsByUserId(id);
        log.info("当前登录用户的角色编号集合：" + role_ids);
        return roleMapper.listRolesByRoleIds(role_ids);
    }


    //根据用户的id查询所有权限信息
    public List<Jurisdiction> getPermissionByUserId(Integer id){
         List<Integer> role_ids = userMapper.listRoleIdsByUserId(id);
         log.info("当前登录用户的角色编号集合：" + role_ids);
         List<Integer> permissions_ids = permissionMapper.listPermissionIdsByRoleIds(role_ids);
         log.info("当前登录用户的角色编号集合对应权限编号集合：" + permissions_ids);
         return permissionMapper.listPermissionsByPermissionIds(permissions_ids);

    }


    public Staff findUserByName(String username) {
         return userMapper.findUserByName(username);
    }

    public void register(String username, String password) {
         String salt= new SecureRandomNumberGenerator().nextBytes().toString();
         String newPass = new SimpleHash("MD5",password,salt,3).toString();
         Staff user = new Staff();
         user.setJobNumber(username);
         user.setPassword(newPass);
         user.setSalt(salt);
         userMapper.insert(user);
    }
    
}
