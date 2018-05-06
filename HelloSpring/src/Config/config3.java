package Config;

import org.springframework.context.annotation.*;

@Configuration
public class config3 {

	@Bean
	public customEventHandler ceh() {
		return new customEventHandler();
	}
	
	@Bean
	public customEventPublisher cecp() {
		return new customEventPublisher();
	}
	
	
}
