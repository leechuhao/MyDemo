package shutDown;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Toast{
	public enum Status{	DRY, BUTTERED, JAMMED}
	private Status status = Status.DRY;
	private final int id;
	public Toast(int idn) {id = idn;}
	public void butter(){status = Status.BUTTERED;}
	public void jam(){status = status.JAMMED;}
	public Status getStatus(){return status;}
	public int getid(){	return id;}
	public String toString(){return "Toast "+ id +": " + status;}
}
class ToastQueue extends LinkedBlockingQueue<Toast>{}

class Toaster implements Runnable{
	private ToastQueue toastQueue;
	private int count=0;
	private Random rand = new Random(47);
	public Toaster(ToastQueue tq){
		toastQueue = tq;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			while(!Thread.interrupted()){
				TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
				Toast t = new Toast(count++);
				System.out.println(t);
				toastQueue.put(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Toast interrupted");
		}
		System.out.println("Toaster Off");
	}
}

class Butterer implements Runnable{
	private ToastQueue dryQueue, butteredQueue;
	public Butterer(ToastQueue dry, ToastQueue butter){
		dryQueue = dry;
		butteredQueue = butter;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			Toast t = dryQueue.take();
			t.butter();
			System.out.println(t);
			butteredQueue.put(t);
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Butterer interrupted");
		}
		System.out.println("Butterer Off");
	}
}

class Jammer implements Runnable{
	private ToastQueue butterQueue, jamQueue;
	public Jammer(ToastQueue butter, ToastQueue jam){
		butterQueue = butter;
		jamQueue = jam;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			Toast t = butterQueue.take();
			t.jam();
			System.out.println(t);
			jamQueue.put(t);
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Jammer interrupted");
		}
		System.out.println("Jammer Off");
	}
}

class Eater implements Runnable{
	private ToastQueue jamQueue;
	int counter = 0;
	public Eater(ToastQueue jam){
		jamQueue = jam;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			while(!Thread.interrupted()){
				Toast t = jamQueue.take();
				if(t.getid() != counter || t.getStatus()!=Toast.Status.JAMMED ){
					System.out.println(">>>>>>Error: "+ t);
					System.exit(1);
				}else{
					System.out.println("Yummy! : " + t);
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Eater interrupted");
		}
		System.out.println("Eater Off");
	}
}

public class ToastMachine {
	public static void main(String[] args) throws Exception{
		ToastQueue dryQueue = new ToastQueue(),
				butterQueue = new ToastQueue(),
				jamQueue = new ToastQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue, butterQueue));
		exec.execute(new Jammer(butterQueue, jamQueue));
		exec.execute(new Eater(jamQueue));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
		
	}
}
