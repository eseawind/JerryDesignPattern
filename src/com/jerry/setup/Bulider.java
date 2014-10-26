package com.jerry.setup;

/**
 * 建造者模式
 * @author Jerry Wang
 *
 */
class Person {
	private String head;
	
	private String body;
	
	private String foot;

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFoot() {
		return foot;
	}

	public void setFoot(String foot) {
		this.foot = foot;
	}
}

class Man extends Person {

}


interface PersonBuilder {
	void buildHead();
	
	void buildBody();
	 
	void buildFoot();
	
	Person buildPerson();
}

class ManBuilder implements PersonBuilder {
	Person person;
	
	public ManBuilder() {
		person = new Man();
	}
 	
	@Override
	public void buildBody() {
		person.setBody("建造男人的身体");
	}

	@Override
	public void buildFoot() {
		person.setFoot("建造男人的脚");
	}

	@Override
	public void buildHead() {
		person.setHead("建造男人的头");
	}

	@Override
	public Person buildPerson() {
		return person;
	}

}

class PersonDirector {
	public Person constructPerson(PersonBuilder pb) {
		pb.buildHead();
		pb.buildBody();
		pb.buildFoot();
		return pb.buildPerson();			
	}
}

public class Bulider {

	public static void main(String[] args) {
		PersonDirector pd = new PersonDirector();
		
		Person person = pd.constructPerson(new ManBuilder());
		
		System.out.println(person.getHead());
		
		System.out.println(person.getBody());
		
		System.out.println(person.getFoot());
	}


}
