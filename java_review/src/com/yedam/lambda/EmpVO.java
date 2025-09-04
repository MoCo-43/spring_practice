package com.yedam.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpVO {

   private int empno;
   private String ename;
   private int dept;
}
