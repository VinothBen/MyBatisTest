package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.dao.LoginAddDao;
import com.cts.dao.LoginAddDaoImpl;

@Service
public class LoginAddServiceImpl implements LoginAddDao {

	@Autowired
	private LoginAddDaoImpl add;

	public void setAdd(LoginAddDaoImpl add) {
		this.add = add;
	}

	public void addLoginDetails(String name, String password) {
		add.addLoginDetails(name, password);
	}

}
