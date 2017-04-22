package interview.designpattern.cor;

public interface DispenseChain {
    public void setNextChain(DispenseChain nextChain);
    
    public void dispense(Currency cur);
    
    public int getMoney();
    
}
