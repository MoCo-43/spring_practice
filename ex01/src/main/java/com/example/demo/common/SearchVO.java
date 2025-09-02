package com.example.demo.common;

import lombok.Data;

// int : null 불가능, 초기값 : 0 
// Integer : null 값 가능, 초기값: null
@Data
public class SearchVO {
  Integer first;
  Integer last;
}
