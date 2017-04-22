package interview.designpattern.cor;

public class RS500Dispenser implements DispenseChain{
	private DispenseChain chain;
	private int numberOfNotes;

	public RS500Dispenser(int numberOfNotes){
		this.numberOfNotes=numberOfNotes;
	}
    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }
 
    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 500){
            int num = cur.getAmount()/500;
            
            if(num <numberOfNotes){
                int remainder = cur.getAmount() % 500;
                System.out.println("Dispensing "+num+" 500 note");
                numberOfNotes=numberOfNotes-num;
                if(remainder !=0) this.chain.dispense(new Currency(remainder));	
                
            }
            else{
                int remainder = cur.getAmount()-numberOfNotes*500;
                System.out.println("Dispensing "+numberOfNotes+" 500 note");
                numberOfNotes=0;
                if(remainder !=0) this.chain.dispense(new Currency(remainder));	
            }
        }else{
            this.chain.dispense(cur);
        }
    }
    

    public int getMoney(){
    	return numberOfNotes*500;
    }

}
