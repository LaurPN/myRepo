package lab1_ex2;

public class SoftwareProduct {
    private String name;
    private String platform;
    private int minRAM;
    private String minCPU;

    public SoftwareProduct(String name, String platform, int minRAM, String minCPU) {
        this.name = name;
        this.platform = platform;
        this.minRAM = minRAM;
        this.minCPU = minCPU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getMinRAM() {
        return minRAM;
    }

    public void setMinRAM(int minRAM) {
        this.minRAM = minRAM;
    }

    public String getMinCPU() {
        return minCPU;
    }

    public void setMinCPU(String minCPU) {
        this.minCPU = minCPU;
    }

    public boolean checkCompatibility(Computer c){
        if (this.minCPU.compareTo(c.getCpu()) < 0){
            if (this.minRAM <= c.getRam()){
                return true;
            }
        }
        return false;
    }
}
