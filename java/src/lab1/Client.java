package lab1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
    private String name;
    private LocalDate bday;
    private String CNP;
    private ArrayList<Account> accounts;
    private Address address;

    public Client(String name, LocalDate bday, String CNP, ArrayList<Account> accounts, Address address) {
        this.name = name;
        this.bday = bday;
        this.CNP = CNP;
        this.accounts = accounts;
        this.address = address;
    }

    public void addAccount(Account a){
        this.accounts.add(a);
    }

    public boolean removeAccount(String IBAN) {
        for (Account a : accounts){
            if(a.getIBAN().equals(IBAN)){
                accounts.remove(a);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", bday=" + bday +
                ", CNP='" + CNP + '\'' +
                ", accounts=" + accounts +
                ", address=" + address.toString() +
                '}';
    }
}
