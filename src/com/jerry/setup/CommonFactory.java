package com.jerry.setup;

/**
 * 普通工厂模式
 * @author Jerry Wang
 *
 */

interface Sender {
	public void send();
}

class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is mail sender");
	}
	
}

class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is sms sender");
	}
	
}

class SendFactory {
	public Sender produce(String type) {
		if("mail".equals(type)) {
			return new MailSender();
		} else if("sms".equals(type)) {
			return new SmsSender();
		} else {
			return null;
		}
	}
}

public class CommonFactory {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce("sms");
		sender.send();
	}
}
