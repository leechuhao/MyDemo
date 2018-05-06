
public class MyNoteBook {
	public static void main (String []args){
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		new Thread(p).start();
		new Thread(c).start();
	}
}

class WoTou{
	int id;
	WoTou (int _id){
		id = _id;
	}
	public String toString(){
		return "Wotou : " + id;
	}
}
class SyncStack{
	int index ;
	WoTou[] arry = new WoTou[6];
	
	public synchronized void push(WoTou t){
		while(index == arry.length){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		arry[index] = t;
		index++;
	}
	
	public synchronized WoTou pop(){
		while(index == 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return arry[index];
	}
}
class Producer implements Runnable{
	SyncStack ss = null;
	Producer(SyncStack ss){
		this.ss = ss;
	}
	public void run(){
		for(int i = 0;i < 20;i++){
			WoTou wt = new WoTou(i);
			ss.push(wt);
			System.out.println("生产了 ：" + wt);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}

class Consumer implements Runnable{
	SyncStack ss = null;
	Consumer(SyncStack ss){
		this.ss = ss;
	}
	public void run(){
		for(int i = 0;i < 20;i++){
			WoTou wt = ss.pop();
			System.out.println("消费了 ：" + wt);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}



