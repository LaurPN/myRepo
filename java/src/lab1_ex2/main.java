package lab1_ex2;

public class main {
    public static void main(String[] args) {
        Computer c = new Computer(4, "i5");
//        Computer c2 = new Computer(4, "i4");
        SoftwareProduct c1 = new SoftwareProduct("dfsdfdsf", "mac", 4, "i3");
        SoftwareProduct c3 = new SoftwareProduct("dfsdfdsf", "mac", 16, "i3");
        System.out.println("Computer: " + c.toString() + "\n" + c.addProduct(c1) + "\n" + c.addProduct(c3));
    }
}
