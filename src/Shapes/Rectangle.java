package Shapes;

public class Rectangle implements Shape {

    private double length;
    private double width;
    private String fillColor;
    private String borderColor;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public double calculatePerimeter() {
        return (2 * (width + length));
    }

    @Override
    public double calculateArea() {
        return (length * width);
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }
}
