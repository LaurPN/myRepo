package lab1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Account implements Comparable<Account>, Storable {
    private String IBAN;
    private int ammount;

    public Account(String IBAN, int ammount) {
        this.IBAN = IBAN;
        this.ammount = ammount;
    }

    public String getIBAN() {
        return IBAN;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public abstract boolean withdraw(int ammount);

    public void deposit(int ammount){
        this.ammount+=ammount;
    }

    @Override
    public int compareTo(Account o) {
        return (this.IBAN.compareTo(o.IBAN));
    }

    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + IBAN + '\'' +
                ", ammount=" + ammount +
                '}';
    }

    @Override
    public void store(String file) {
        try{
            FileWriter myWriter = new FileWriter(file + ".txt");
            myWriter.write(this.toString());
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
