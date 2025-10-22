package solutions.lab2.task4;

public class Container {
    public double capacity;
    public double availableSpace;

    public Container(double capacity) {
        this.capacity = capacity;
        this.availableSpace = capacity;
    }

    public boolean add(Shape shape) {
        double shapeVolume = shape.getVolume();

        if (shapeVolume <= availableSpace) {
            availableSpace -= shapeVolume;
            System.out.println("Фигура успешно добавлена. Осталось места: " + availableSpace);
            return true;
        } else {
            System.out.println("Невозможно добавить фигуру. Недостаточно места.");
            return false;
        }
    }

    public double getAvailableSpace() {
        return this.availableSpace;
    }
}
