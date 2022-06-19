package com.busticketbooking.util;

import com.busticketbooking.bean.SendEmail;

public class EmailThread implements Runnable {
	public String email, message;

	public void send(String mail, String msg) {
		email = mail;
		message = msg;
	}

	@Override
	public void run() {
		SendEmail mail = new SendEmail();

		mail.sendmail(email, message);
	}
}
