package interview.thread;
/*
 * Simulate Three Thread to print 1 2 3 1 2 3 1 2 3...
 * Different Thread prints 1 2 and 3
 * Improve it for N Threads
 * */
public class SimulateThreeThread {
	
	public static void main(String[] args) {
		SharedObject shared = new SharedObject();
		
		Thread t1= new Thread(new MyThread(shared, 1),"Thread 1");
		Thread t2= new Thread(new MyThread(shared, 2),"Thread 2");
		Thread t3= new Thread(new MyThread(shared, 3),"Thread 3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class SharedObject {
	boolean one=true;
	boolean two;
	boolean three;
	public void print(int i) throws InterruptedException{
		
		while(true){
			Thread.sleep(1000);
			synchronized (this) {
			if(i==1){
				while(!one){
					wait();
				}
				System.out.println(Thread.currentThread().getName() +" :"+i);
				one=false;
				two=true;
				three=false;
				notifyAll();
			}
			else if(i==2){
				while(!two){
					wait();
				}
				System.out.println(Thread.currentThread().getName() +" :"+i);
				one=false;
				two=false;
				three=true;
				notifyAll();
			}
			
			else if(i==3){
				while(!three){
					wait();
				}
				System.out.println(Thread.currentThread().getName() +" :"+i);
				one=true;
				two=false;
				three=false;
				notifyAll();
			}
		 }
		}
		
	}
}

class MyThread implements Runnable{

	private SharedObject shared;
	private int i;
	public MyThread(SharedObject shared,int i) {
		this.shared=shared;
		this.i=i;
	}
	@Override
	public void run() {
		try {
			shared.print(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
