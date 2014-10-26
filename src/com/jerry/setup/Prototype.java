package com.jerry.setup;

/**
 * 原型模式
 * @author Jerry Wang
 *
 */
public class Prototype implements Cloneable{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Object clone(){
        try {
            return super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public static void main(String[] args) {
		Prototype pro = new ConcretePrototype("prototype");
		Prototype pro2 = (Prototype) pro.clone();
		System.out.println(pro.getName());
		System.out.println(pro2.getName());
	}
}


class ConcretePrototype extends Prototype {

	public ConcretePrototype(String name) {
		super.setName(name);
	}
}
