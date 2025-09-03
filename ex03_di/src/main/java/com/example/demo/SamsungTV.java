package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Lazy // 지연로딩
@Scope("singleton")
@Component
//@RequiredArgsConstructor
public class SamsungTV implements TV {

	// @Autowired사용하지 않는다면 보통 이렇게 사용
	@Setter(onMethod_={@Autowired})
	Speaker speaker;
	
/*  // DI(의존성 주입) //
    생성자 주입방법
//	@Autowired	
	
	// 생성자 주입방법을 쓰지 않으면 사용  //
//	public SamsungTV(Speaker speaker) {
//		this.speaker = speaker;
//	}
	
	// setter 주입방법  //
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}
	*/
	
	@Override
	public void powerOn() {
		System.out.println("삼성 TV--전원 on");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성 TV--전원 off");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
//		System.out.println("삼성 TV--볼륨 down");
		// DI(의존성 주입)
		speaker.volumeDown();
	}
}