package interview.thread;
/*
 * Improve it further
 * */
public class SimulateNThreads {
	
	public static void main(String[] args) {
		
		int numberOfThread =9;
		
		SharedObjectWithNThread shared = new SharedObjectWithNThread(numberOfThread);
		
		for(int i=0;i<numberOfThread;i++){
			(new Thread(new MyRunnable(shared,(i+1)),"Thread "+(i+1))).start();;
		}
		
	}

}

class SharedObjectWithNThread {
	
	volatile boolean[] threads;
	public SharedObjectWithNThread(int maxThreads) {
		threads=new boolean[maxThreads];
		threads[0]=true;
	}

	public void print(int x) throws InterruptedException{
		
		while(true){
			Thread.sleep(1000);
			synchronized (this) {
			
				for(int i=0;i<threads.length;i++){
					
					if((i+1)==x){
						while(!threads[i]){
							wait();
						}
						
						for(int j=0;j<threads.length;j++){
							threads[j]=false;
						}
						
						int nextThread=i+1;
						
						if(nextThread==threads.length){
							nextThread=0;
						}
						
						threads[nextThread]=true;
						
						System.out.println(Thread.currentThread().getName() +" :"+x);
						notifyAll();
					}
					
				}
			}
		}
		
	}
}

class MyRunnable implements Runnable{

	private SharedObjectWithNThread shared;
	private int x;
	public MyRunnable(SharedObjectWithNThread shared,int x) {
		this.shared=shared;
		this.x=x;
	}
	@Override
	public void run() {
		try {
			shared.print(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
