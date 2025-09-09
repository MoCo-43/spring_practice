package yedam.service;

import java.util.Date;

import lombok.Data;

@Data
public class RentVO {

	private Long rentNo;
	private Long bookNo;
	private Long rentPrice;
	private Date rentDate;
	private char rentStatus;
}
