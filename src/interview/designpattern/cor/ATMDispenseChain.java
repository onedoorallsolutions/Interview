package interview.designpattern.cor;
import java.util.Scanner;

public class ATMDispenseChain {
 
    private static DispenseChain c1;
    private static DispenseChain c2;
    private static DispenseChain c3;
    
    public ATMDispenseChain() {
        // initialize the chain
        this.c1 = new RS1000Dispenser(10);
        this.c2 = new RS500Dispenser(1);
        this.c3 = new RS100Dispenser(11);
 
        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        
        
        
    }
 
    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 100 != 0) {
                System.out.println("Amount should be in multiple of 100s.");
                return;
            }
            if(amount >totalMoney()){
            	 System.out.println("Doesn't have sufficient balance.");
            }else{
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
            }
         
    }
    
    public static int totalMoney(){
    	return c1.getMoney()+c2.getMoney()+c3.getMoney();
    }
 
}