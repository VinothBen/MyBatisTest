package com.cts.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.vo.LoginDetails;



@Repository
public class LoginAddDaoImpl implements LoginAddDao {
    
	@Autowired
	private SqlSessionFactory sql;
	
	public void setSql(SqlSessionFactory sql) {
		this.sql = sql;
	}


	public void addLoginDetails(String name, String password) {
		
		
		 SqlSession session=sql.openSession();
		 List<LoginDetails> list = new ArrayList<LoginDetails>();
		 
		 list = session.selectList("LoginDetails.selectAll");
		 for(LoginDetails n:list) {
			 System.out.println(n.getName()+"::"+n.getId());
		 }
		 System.out.println(list);
		 System.out.println(name+"  "+password);
		 session.close();
	}

}
