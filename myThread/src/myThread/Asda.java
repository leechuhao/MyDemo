package myThread;

public class Asda {
	public synchronized void doit(){
		int num = 10;
		if(num > 0){
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace( );
			}
			System.out.println(--num);
		}
	}
	
	private void run() {
		while(true){
			doit();
		}

	}
}
