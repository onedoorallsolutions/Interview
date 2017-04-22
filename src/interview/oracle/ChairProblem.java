package interview.oracle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ChairProblem {
	final static int SIZE=5;
	final static LinkedList<Student> list = new LinkedList<Student>();
	final static Map<String,Student> chairMap=new HashMap<String,Student>(SIZE);
	
	public static void main(String[] args){
		
		final ChairProblem cp = new ChairProblem();
		
		cp.init(chairMap);
		
		
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					cp.produceStudent();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					cp.consumeStudent();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		Thread t3= new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					cp.removeFromChair();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		t1.start();
		t2.start();
		t3.start();
		
	  }
	
	
	public void removeFromChair() throws InterruptedException{
		
		Thread.sleep(5000);
		while(true){
			synchronized (chairMap) {
				Random r = new Random();
				int x = r.nextInt(1000);
				if( x<100){
					chairMap.wait();
				}
				
				int chairId = r.nextInt(5);
				if(chairId !=0){
				chairMap.put("chair"+chairId, null);
		
				System.out.println("Map :"+chairMap);
				chairMap.notify();
				}
			}
			
		}
	}


	public void produceStudent() throws InterruptedException{
		int i=0;
		while(true){
			
			synchronized (this) {
				
				while(list.size() == SIZE){
					System.out.println("Queue is full with student...");
					wait();
				}
				i++;
				list.addLast(new Student(i, "Student-"+i));
				System.out.println("Added Student"+i+" to the queue...");
				notify();
				
				Thread.sleep(1000);
				
			}	
		}
	}
	
	public void consumeStudent() throws InterruptedException{
		while(true){
			synchronized (this) {
				while(list.size()==0 ){
					System.out.println("No Student in the Queue...");
					wait();
				}
				
				Student s1= list.removeFirst();
				
				synchronized (chairMap) {
					
					String chairId = checkFreeChair(chairMap);
					while(chairId==null){
						System.out.println("Waiting for Chair to be freed...");
						chairMap.wait();
					}
					
					System.out.println(chairId +" Is Freed..");
					System.out.println("Assigning "+s1);
					chairMap.put(chairId, s1);	
				
					System.out.println("Map :"+chairMap);
					chairMap.notify();
				}
				
				notify(); 
				
			}
			

			
		}
		
		
	}

	
	
	
	String  checkFreeChair(Map<String, Student> chairMap) {
		
		Set<Map.Entry<String, Student>> entrySet = chairMap.entrySet();
		
		for(Map.Entry<String, Student> entry : entrySet){
			
			if(entry.getValue()==null){
				return entry.getKey();
			}
		}
		return null;
		
	}


	
	void init(Map<String,Student> chairMap){
		
		for(int i=0;i<SIZE;i++){
			chairMap.put("chair"+(i+1), null);
		}
	}
	

}













class Student{
	private int rollNo;
	private String name;
	public Student(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNo != other.rollNo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return name;
	}
	
	
}
