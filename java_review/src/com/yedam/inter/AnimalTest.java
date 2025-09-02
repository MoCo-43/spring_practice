package com.yedam.inter;

import org.junit.jupiter.api.Test;

/*
 * 다형성
 * 부모타입 참조변수가 자식객체 참조
 * 참조하는 자식객체의 메소드를 호출 -> 실행 결과 다르게 보임
 */

public class AnimalTest {

	@Test
	public void test() {
		Animal animal = new Dog();
		animal.sound();
	}

	
}
