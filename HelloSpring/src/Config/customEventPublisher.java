package Config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class customEventPublisher implements ApplicationEventPublisherAware{
	private ApplicationEventPublisher publisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		// TODO Auto-generated method stub
		this.publisher = arg0;		
	}
	
	 public void publish() {
		customEvent ce = new customEvent(this);
		publisher.publishEvent(ce);
	 }

}
