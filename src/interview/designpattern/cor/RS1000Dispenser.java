package interview.designpattern.cor;

public class RS1000Dispenser implements DispenseChain{
private DispenseChain chain;
private int numberOfNotes;
	public RS1000Dispenser(int numberOfNotes){
		this.numberOfNotes=numberOfNotes;
	}
    
    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }
 
    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 1000){
            int num = cur.getAmount()/1000;
            if(numberOfNotes>num){
                int remainder = cur.getAmount() % 1000;
                System.out.println("Dispensing "+num+" 1000 note");
                numberOfNotes=numberOfNotes-num;
                if(remainder !=0) this.chain.dispense(new Currency(remainder));	
                
            }
            else{
                int remainder = cur.getAmount()-numberOfNotes*1000;
                System.out.println("Dispensing "+numberOfNotes+" 1000 note");
                numberOfNotes=0;
                if(remainder !=0) this.chain.dispense(new Currency(remainder));	
            }
            
          

        }else{
            this.chain.dispense(cur);
        }
    }
    
    public int getMoney(){
    	return numberOfNotes*1000;
    }
}
