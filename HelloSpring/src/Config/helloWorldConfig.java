package Config;

import org.springframework.context.annotation.*;

@Configuration
public class helloWorldConfig {
	@Bean
	@Scope("prototype")
	public helloWorld hello() {
		return new helloWorld();
	}
}
