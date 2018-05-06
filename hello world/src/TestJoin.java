
public class TestJoin {
	public static void main (String []args){
		MyThread t1 = new MyThread("dick");
		t1.start();
		
		
		for(int i = 1;i <= 100;i++){
			System.out.println("I`m a thread.");
		try{
			t1.join();
		}catch(InterruptedException e){	}
		}
	}
}


//implements Runnable
//extends Thread
class MyThread extends Thread{
	MyThread(String s){
		super(s);
	}
	public void run(){
		for(int i = 1;i <= 10;i++){
			System.out.println( "I am a "+ getName());
			try {
				sleep(1000);
			}catch(InterruptedException ae){return;}
		}
	}
}