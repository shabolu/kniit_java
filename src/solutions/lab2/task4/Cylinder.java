package solutions.lab2.task4;

public class Cylinder extends Shape {
    public double height;
    public double radius;

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
