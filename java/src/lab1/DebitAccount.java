package lab1;

public class DebitAccount extends Account{

    public DebitAccount(String IBAN, int ammount) {
        super(IBAN, ammount);
    }

    @Override
    public boolean withdraw(int ammount) {
        if (ammount <= this.getAmmount()){
            this.setAmmount(this.getAmmount() - ammount);
            return true;
        }
        return false;
    }
}
