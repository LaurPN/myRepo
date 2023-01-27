package lab2_homework_problem_1;

public class Rectangle extends GeometricalForm{
    private int width;
    private int height;

    public Rectangle(int xCoord, int yCoord, int width, int height) {
        super(xCoord, yCoord);
        this.width = width;
        this.height = height;
    }

    @Override
    public void move(int x, int y) {
        this.setxCoord(x);
        this.setyCoord(y);
    }

    @Override
    public void shrink() {
        this.width--;
        this.height--;
    }

    @Override
    public void changeInnerColor(String color) {
        this.setiColor(color);
    }

    @Override
    public void enlarge() {
        this.height++;
        this.width++;
    }

    @Override
    public void changeFormColor(String color) {
        this.setfColor(color);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
