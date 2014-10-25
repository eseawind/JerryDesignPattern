package com.jerry.setup;

/**
 * 单例模式--懒汉,使用synchronized避免线程不同步
 * @author Jerry Wang
 *
 */
public class Singleton1 {
	private static Singleton1 instance = null;

	private Singleton1() {
		// dosomething
	}
	
	/**
	 *  1、 第一个条件是说，如果实例创建了，那就不需要同步了，直接返回就好了。
	 *  2 、不然，我们就开始同步线程。
	 *  3 、第二个条件是说，如果被同步的线程中，有一个线程创建了对象，那么别的线程就不用再创建了
	 */
	public static Singleton1 getInstance() {
		if (null == instance) {
			synchronized (Singleton1.class) {
				if (null == instance) {
					instance = new Singleton1();
				}
			}
		}
		return instance;
	}
}