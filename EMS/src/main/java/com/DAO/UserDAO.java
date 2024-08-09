package com.DAO;

import com.entity.User;

public interface UserDAO {

	public boolean userRegister(User us);
	
	public User login(String email, String password);
	
	public boolean checkpassword(int id,String pswd);
	public boolean editprofile(User us);
	
	public boolean checkUser(String email);
}
