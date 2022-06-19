package com.busticketbooking.service;

import com.busticketbooking.bean.User;

public interface UserService {

	public String saveUserRegistration(User user);

	public int checkEmailExist(String email);

	public User checkLoginDetails(String email, String password);

	public String fetchPassword(String email);
}
