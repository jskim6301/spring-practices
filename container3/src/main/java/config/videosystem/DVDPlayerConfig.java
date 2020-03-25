package config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
	
	@Bean
	public Avengers avengers() {
		return new Avengers();
	}
	
	//주입하기1 : Bean 생성 메소드 직접 호출
//	@Bean 
	public DVDPlayer dvdPlayer01() {
		return new DVDPlayer(avengers());
	}
	
	//주입하기 2 : 파라미터로 Bean 전달하기
	@Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}

}
