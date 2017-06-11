package interview.designpattern.observer;

import java.util.HashSet;
import java.util.Set;

public class SubjectImpl implements Subject{

	Set<Observer> observerList;
	private String channel;
	public SubjectImpl(){
		observerList= new HashSet<>();
	}
	@Override 
	public void addObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for(Observer observer : observerList){
			observer.update(channel);
		}
	}
	
	public void updateChannel(String channel){
		this.channel=channel;
		notifyObserver();
	}

	
}
