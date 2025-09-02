package com.yedam.collect;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * List
 * Set
 * Map
 */
public class ListTest {
	@DisplayName("Map ")
	@Test
	public void test3() {
       //검색
	  Map<String, String> map = new HashMap<>();
	  map.put("100", "홍길동");
	  map.put("101", "김유신");
	  
	  map.get(100);  // 검색속도 map:1  list:n
	}
	
	@DisplayName("List ")
	@Test
	public void test1() {
		List<String> list = new ArrayList<>();
		list.add("사과");
		list.add("바나나");
		list.add("사과");
		assertEquals(list.size(), 3);
		
		// list를 set에 넣으면 중복값을 알아서 저장
		Set<String> set = new HashSet<>(list);
		assertEquals(list.size(), 2);
	}
	@DisplayName("Set ")
	@Test
	public void test2() {
		Set<String> list = new HashSet<>();
		list.add("사과");
		list.add("바나나");
		list.add("사과");
		assertEquals(list.size(), 2);
	}
}