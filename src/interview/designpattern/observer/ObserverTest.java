package interview.designpattern.observer;

public class ObserverTest {

	public static void main(String[] args) {
		Observer observer = new ObserverImpl("Observer 1");
		
		Subject subject = new SubjectImpl();
		
		subject.addObserver(observer);
		Observer observer2 = new ObserverImpl("Observer 2");
		Observer observer3 = new ObserverImpl("Observer 3");
		Observer observer4 = new ObserverImpl("Observer 4");
		Observer observer5 = new ObserverImpl("Observer 5");
		subject.addObserver(observer2);
		subject.addObserver(observer3);
		subject.addObserver(observer4);
		subject.addObserver(observer5);
		
		subject.updateChannel("Republic");
		subject.removeObserver(observer5);
		subject.updateChannel("Times Now");
		subject.removeObserver(observer4);
		subject.updateChannel("NDTV");
		subject.removeObserver(observer3);
		
		subject.updateChannel("AAJ TAK");
	}
}
