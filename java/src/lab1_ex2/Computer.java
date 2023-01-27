package lab1_ex2;

import java.util.ArrayList;

public class Computer {
    private int ram;
    private String cpu;
    private ArrayList<SoftwareProduct> SoftwareProducts = new ArrayList<SoftwareProduct>();

    public Computer(int ram, String cpu) {
        if (ram != 4 && ram != 8 && ram != 16 && ram != 32) {
            throw new IllegalArgumentException("BAD RAM");
        } else {
            this.ram = ram;
        }
        if (cpu != "i3" && cpu != "i5" && cpu != "i7") {
            throw new IllegalArgumentException("BAD CPU");
        } else {
            this.cpu = cpu;
        }
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public ArrayList<SoftwareProduct> getSoftwareProducts() {
        return SoftwareProducts;
    }

    public void setSoftwareProducts(ArrayList<SoftwareProduct> softwareProducts) {
        SoftwareProducts = softwareProducts;
    }

    public  boolean addProduct(SoftwareProduct p) {
        if (p.checkCompatibility(this)) {
            SoftwareProducts.add(p);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", cpu='" + cpu + '\'' +
                ", SoftwareProducts=" + SoftwareProducts +
                '}';
    }
}
