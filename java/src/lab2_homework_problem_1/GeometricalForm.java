package lab2_homework_problem_1;

public abstract class GeometricalForm implements FormOperations {
    private int xCoord;
    private int yCoord;
    private String iColor = new String();
    private String fColor = new String();

    public GeometricalForm(int xCoord, int yCoord) {
        this.yCoord = yCoord;
        this.xCoord = xCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public String getiColor() {
        return iColor;
    }

    public String getfColor() {
        return fColor;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public void setiColor(String iColor) {
        this.iColor = iColor;
    }

    public void setfColor(String fColor) {
        this.fColor = fColor;
    }
}
