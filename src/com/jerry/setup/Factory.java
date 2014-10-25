package com.jerry.setup;

/**
 * 工厂模式
 * @author Jerry Wang
 *
 */
interface Work {
	void doWork();
}

class TeacherWork implements Work {

	@Override
	public void doWork() {
		System.out.println("老师批改作业");
	}
	
}

class StudentWork implements Work {

	@Override
	public void doWork() {
		System.out.println("学生批改作业");
	}
	
}

interface IWorkFactory {
	Work getWork();
}

class StudentWorkFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		return new StudentWork();
	}

}

class TeacherWorkFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		return new TeacherWork();
	}

}

public class Factory {

	public static void main(String[] args) {
		IWorkFactory studentWorkFactory = new StudentWorkFactory();
		studentWorkFactory.getWork().doWork();

		IWorkFactory teacherWorkFactory = new TeacherWorkFactory();
		teacherWorkFactory.getWork().doWork();
	}
}
