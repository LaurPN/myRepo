package lab1_hw;

public class Main {
    public static void main(String[] args){
        Bank b1 = new Bank();
        Person p1 = new Person("Popescu", "Alexandru", "5021205340449");
        Loan l1 = new Loan(45, 123231.4, p1);
        Loan l2 = new Loan(46, 342134.34, p1);
        Loan l3 = new Loan(47, 3414, p1);

        b1.addLoan(l1);
        b1.addLoan(l2);
        b1.addLoan(l3);

        System.out.println(b1.toString() + "\n");

        System.out.println(b1.find("Alexandru") + "\n");
        System.out.println(b1.find("Alexandru", 300000) + "\n");

        System.out.println(b1.removeLoan(l2) + "\n");

        System.out.println(b1.toString() + "\n");

        b1.printInFile("test");
    }
}
