package Config;

import org.springframework.context.ApplicationListener;

public class customEventHandler implements ApplicationListener<customEvent>{

	@Override
	public void onApplicationEvent(customEvent arg0) {
		// TODO Auto-generated method stub
		  System.out.println(arg0.toString());
	}

}
