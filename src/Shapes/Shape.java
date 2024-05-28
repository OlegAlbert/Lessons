package Shapes;

public interface Shape {

    double calculatePerimeter();
    double calculateArea();

    String getBorderColor();
    void setBorderColor(String borderColor);

    String getFillColor();
    void setFillColor(String fillColor);

    default void printShape() {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}
