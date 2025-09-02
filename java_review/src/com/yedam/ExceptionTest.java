package com.yedam;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class Score {
  // throws : 예외처리를 하지 않고 호출한 메소드로 예외 던짐
	public void input() throws Exception {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = total(n1, n2);
		System.out.println("result=" + n3);
	}

	public int total(int n1, int n2) throws Exception {
		// 업무 규칙에 위배되는 경우 예외 발생
		if (n1 < 0 || n2 < 0) {
			throw new Exception("음수 입력");
		}
		int result = n1 + n2;
		return result;
	}

}

public class ExceptionTest {
	@Test
	public void test() {
		Score score = new Score();
		// input 메소드 호출(실행)
		try {
			score.input();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("the end");

	}
}
