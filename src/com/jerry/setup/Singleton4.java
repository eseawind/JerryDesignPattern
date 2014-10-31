package com.jerry.setup;

import java.util.Vector;

/**
 * 采用"影子实例"的办法为单例对象的属性同步更新
 * @author Jerry Wang
 *
 */
public class Singleton4 {
	private static Singleton4 instance = null;
	private Vector properties = null;

	public Vector getProperties() {
		return properties;
	}

	private Singleton4() {
	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new Singleton4();
		}
	}

	public static Singleton4 getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}

	public void updateProperties() {
		Singleton4 shadow = new Singleton4();
		properties = shadow.getProperties();
	}
}
