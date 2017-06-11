package interview.designpattern.observer;

public interface Subject {

	public void addObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObserver();
	public void updateChannel(String channel);
}
