package lab2_homework_problem_1;

public class Main {
    public static void main(String[] args) {
        GeometricalForm rectangle = new Rectangle(12,26, 25, 18);
        GeometricalForm ellipse = new Elipse(12, 10, 9, 20);

        System.out.println(rectangle.getxCoord());
        System.out.println(rectangle.getyCoord());
        rectangle.setfColor("red");
        rectangle.setiColor("blue");
        System.out.println(rectangle.getfColor());
        System.out.println(rectangle.getiColor());
        System.out.println(ellipse.getxCoord());
        System.out.println(ellipse.getyCoord());
        ellipse.setiColor("purple");
        ellipse.setfColor("brown");
        System.out.println(ellipse.getfColor());
        System.out.println(ellipse.getiColor());
        ellipse.shrink();
        System.out.println(ellipse.toString());
        ellipse.enlarge();
        ellipse.enlarge();
        ellipse.enlarge();
        System.out.println(ellipse.toString());
    }
}
