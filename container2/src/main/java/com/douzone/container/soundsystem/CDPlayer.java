package com.douzone.container.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	
	private CompactDisc cd;
	
	public CDPlayer() {	
	}
	
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}
	
	
	public void play() {
		cd.play();
		
	}
}
