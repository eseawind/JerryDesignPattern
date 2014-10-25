package com.jerry.principle;

/**
 * 开闭原则
 * 软件实体应当对扩展开放，对修改关闭
 * @author Jerry Wang
 *
 */
// 将技巧抽象为一个方法，单独拿出来
interface Skill {
	public void skill();
}

// 詹姆斯的技巧
class JamesSkill implements Skill {
	public void skill() {
		System.out.println("詹姆斯的技巧：战斧式扣篮");
	}
};

// 科比的技巧
class KobeSkill implements Skill {
	public void skill() {
		System.out.println("科比的技巧： 后仰跳投");
	}
};

// 艾弗森的技巧
class AISkill implements Skill {
	public void skill() {
		System.out.println("艾弗森的技巧： 变相");
	}
};

/*
 * 抽象的方法拿出来后，有不同的类来实现抽象方法这个接口，让不同的选手持有不同的行为类，这个设计方案叫做封装可变形。
 * 同时，在后面的设计模式中我们也会讲到，这个叫做策略模式
 */
class NBAPlayer {
	// 姓名
	private String name;
	private Skill skill;

	public NBAPlayer(String name, Skill skill) {
		this.name = name;
		this.skill = skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Skill getSkill() {
		return skill;
	}

	public String getName() {
		return name;
	}

	public void action() {
		skill.skill();
	}
};

public class OpenClosedPrincipl {

	public static void main(String[] args) {
		// 不同的技巧
		Skill jamesSkill = new JamesSkill();
		Skill kobeSkill = new KobeSkill();
		Skill aiSkill = new AISkill();

		// 不同的球员
		NBAPlayer james = new NBAPlayer("James", jamesSkill);
		NBAPlayer kobe = new NBAPlayer("kobe", kobeSkill);
		NBAPlayer ai = new NBAPlayer("AI", aiSkill);

		// 会有不同的表现
		james.action();
		kobe.action();
		ai.action();
	}
}
