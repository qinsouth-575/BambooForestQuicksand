package com.forest.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forest.entity.Staff;
import com.forest.mapper.StaffMapper;

@Service
public class LoginBiz {
	@Autowired
		private StaffMapper dao;
	//查询账户密码
	public Staff queryNameAndPwd(Staff staff) {
		return dao.queryNameAndPwd(staff);
	}
		
}
