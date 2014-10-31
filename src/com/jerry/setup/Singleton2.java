package com.jerry.setup;

/**
 * 单例模式--懒汉模式
 * @author Jerry Wang
 *
 */
public class Singleton2 {
	private static  Singleton2 instance = new Singleton2() ;
	private Singleton2() {}
	
	public static Singleton2 getInstance() {
		return instance;
	}
}

