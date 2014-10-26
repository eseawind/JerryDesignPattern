package com.jerry.structure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * 享元模式
 * @author Jerry Wang
 *
 */

abstract class Intrinsic{
    abstract public void show(String state);//声明了一个show方法，这里用来展示字母
}

class ConcreteIntrinsic extends Intrinsic {
	private Character intrinsicState = null;// 内部状态

	// 构造函数，内部状态作为参数穿进去
	public ConcreteIntrinsic(Character state) {
		intrinsicState = state;
	}

	// 根据外部状态来展示
	public void show(String state) {
		System.out.println("我是  " + intrinsicState + "    当前字体为：" + state);
	}
}

class IntrinsicFactory {
	private HashMap<Character,Intrinsic> map = new HashMap<Character,Intrinsic>(); // 用来存储享元对象

	public IntrinsicFactory() {
	}

	// 创建享元对象的方法，内部状态作为参数输入
	public Intrinsic factory(Character state) {
		if (map.containsKey(state)) {
			return map.get(state);
		} else {
			Intrinsic ft = new ConcreteIntrinsic(state);
			map.put(state, ft);
			return ft;
		}
	}
	
	// 遍历享元
	public void checkIntrinsic(){
		System.out.println("=========checkIntrinsic==================");
		int i=0;
		for(Iterator<Entry<Character, Intrinsic>> it = map.entrySet().iterator();it.hasNext();i++){
			Entry<Character, Intrinsic> e = it.next();
			System.out.println("第"+i+"项是："+e.getKey());
		}
		System.out.println("=========checkIntrinsic==================");
	}
}

public class Flyweight {  
    IntrinsicFactory factory = new IntrinsicFactory();  
      
    void run(){  
        Intrinsic fly = factory.factory(new Character('a'));  
        fly.show("宋体");// 这个a是宋体的格式  
        fly = factory.factory(new Character('b'));  
        fly.show("xx体");// 这个b是xx体的格式  
        fly = factory.factory(new Character('a'));  
        fly.show("宋体");// 这个a是宋体的格式  
        factory.checkIntrinsic();  
    }  
    public static void main(String[] args) {  
        new Flyweight().run();  
    }  
}  