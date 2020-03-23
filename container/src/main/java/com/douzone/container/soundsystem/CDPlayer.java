package com.douzone.container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	//Wiring 01 : 바이너리 주입(CGLib)   => 가장 추천하는 방식
//	@Inject (자바 표준 Wiring 어노테이션)
	@Autowired // (스프링 Wiring 어노테이션)
	@Qualifier("highSchoolRapper3Final") //(앞에 소문자) @Qualifier("HSSchoolRapper")
	private CompactDisc cd;

	public CDPlayer() {
	}
	
	//Wiring 02 : 생성자 주입	(예전방식)
//	@Autowired
	public CDPlayer(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	//Wiring 03 : setter사용 가능
//	@Autowired
	public void setCompactDisc(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}

	//Wiring 04 : 일반 메소드로도  사용 가능
//	@Autowired	
	public void insertCompactDisc(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	public void play() {
		cd.play();
		
	}

}
