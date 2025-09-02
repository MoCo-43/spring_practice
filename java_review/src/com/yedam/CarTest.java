package com.yedam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	
	@Test
	public void test3() {
	  Car car1 = new Car("쏘렌토");
	  car1.setModel("테슬라");
	  System.out.println(car1.getModel());
	}
	
	
    @DisplayName("객체생성")
	@Test  // static void main이 없어도 실행가능
	public void test2() {

		Car car1 = new Car("쏘렌토");
		Car car2 = new Car("카니발");

		assertEquals(car1,car2);
	}
	
	// 싱글톤
    @DisplayName("싱글톤")
	@Test
	public void test() {

		Car car1 = Car.getInstance("쏘렌토");
		Car car2 = Car.getInstance("카니발");
		new Car(" ");
		car1.drive();
		car2.drive();


		assertEquals(car1,car2);
	}
}
