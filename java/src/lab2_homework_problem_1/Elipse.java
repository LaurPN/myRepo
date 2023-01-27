package lab2_homework_problem_1;

public class Elipse extends GeometricalForm{
    private int hRadius;
    private int vRadius;

    public Elipse(int xCoord, int yCoord, int hRadius, int vRadius) {
        super(xCoord, yCoord);
        this.vRadius = vRadius;
        this.hRadius = hRadius;
    }

    @Override
    public void move(int x, int y) {
        this.setxCoord(x);
        this.setyCoord(y);
    }

    @Override
    public void shrink() {
        this.hRadius--;
        this.vRadius--;
    }

    @Override
    public void changeInnerColor(String color) {
        this.setiColor(color);
    }

    @Override
    public void enlarge() {
        this.hRadius++;
        this.vRadius++;
    }

    @Override
    public void changeFormColor(String color) {
        this.setfColor(color);
    }

    @Override
    public String toString() {
        return "Elipse{" +
                "hRadius=" + hRadius +
                ", vRadius=" + vRadius +
                '}';
    }

    public int getHorizRadius() {
        return hRadius;
    }

    public int getVertRadius() {
        return vRadius;
    }
}
