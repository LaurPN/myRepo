package lab1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Address a1 = new Address("Bucuresti", 38, "Dunarii");
        LocalDate date1 = LocalDate.of(2002, 12, 5);
        ArrayList<Account> a = new ArrayList<>();
        Client c1 = new Client("laur", date1, "21231231231312", a, a1);
        DebitAccount a2 = new DebitAccount("RO16BTRL2131231232131232", 345555);
        CreditAccount a3 = new CreditAccount("RO17BTRL231343252523413", 342324, 21313123);
        Account[] aPrime = {a2, a3};
        Arrays.sort(aPrime);

        System.out.println("First client");
        System.out.println(c1.toString());
        c1.addAccount(a2);
        c1.addAccount(a3);

        System.out.println("Transactions debit account: ");
        System.out.println(a2.withdraw(1500));
        System.out.println(a2.withdraw(23232323));

        System.out.println("Transactions credit account: ");
        System.out.println(a3.withdraw(1500));
        System.out.println(a3.withdraw(23232323));

//        System.out.println("Deletion of accounts");
//        System.out.println(c1.removeAccount("RO16BTRL2131231232131232"));
//        System.out.println(c1.removeAccount("RO16BTRL21312312321312"));

        System.out.println(Arrays.toString(aPrime));
        a2.store("Debit");
        a3.store("Credit");

    }
}
