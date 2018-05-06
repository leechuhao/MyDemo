package myThread;

public class ThreadSafeTest implements Runnable{
	int num = 10;
	public void run(){
		while(true){
			synchronized(""){/////线程同步
				if(num > 0){
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace( );
					}
					System.out.println("tickets" + num--);
				}
			}
		}
	}

	public static void main(String[] args) {
		ThreadSafeTest t = new ThreadSafeTest();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
}
