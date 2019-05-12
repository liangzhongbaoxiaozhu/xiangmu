package com.lzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.lzb.dao.Usersdao;
import com.lzb.entity.Users;

@Component
public class UsersServiceImpl implements UsersService{

	@Autowired
	private Usersdao usersdao;
	@Override
	public Users DengLu(Users user) {
		// TODO Auto-generated method stub
		return usersdao.DengLu(user);
	}

}
