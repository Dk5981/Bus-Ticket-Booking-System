package com.busticketbooking.service;

import java.util.List;

import com.busticketbooking.bean.User;

public interface UserService {

	public String saveUserRegistration(User user);

	public int checkEmailExist(String email);

	public User checkLoginDetails(String email, String password);

	public String fetchPassword(String email);

	public User getUserDetails(int userId);

	public List<User> getUserDetails();
}
