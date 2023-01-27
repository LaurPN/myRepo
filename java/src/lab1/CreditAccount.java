package lab1;

public class CreditAccount extends Account{

    private int maxCredit;

    public CreditAccount(String IBAN, int ammount, int maxCredit) {
        super(IBAN, ammount);
        this.maxCredit = maxCredit;
    }

    @Override
    public boolean withdraw(int ammount) {
        if (ammount <= this.maxCredit + this.getAmmount()) {
            this.setAmmount(this.maxCredit + this.getAmmount() - ammount);
            return true;
        }
        return false;
    }

}
