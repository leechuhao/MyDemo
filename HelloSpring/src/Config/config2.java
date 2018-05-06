package Config;

import org.springframework.context.annotation.*;

@Configuration
public class config2 {
	@Bean
	public helloWorld hello() {
		helloWorld hw = new helloWorld();
		hw.setMessage("config helloWorld");
		return hw;
	}
	
	@Bean
	public cStartedEventHandler cstart() {
		return new cStartedEventHandler();
	}
	
	@Bean
	public cStopedEventHandler cstop() {
		return new cStopedEventHandler();
	}
}
