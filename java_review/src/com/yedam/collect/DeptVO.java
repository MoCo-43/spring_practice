package com.yedam.collect;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeptVO {
  final private int deptno;
  final private String dname;
  private int location;
}
