package by.innowise.task1.bean.ball;

public abstract class Ball {
    private int size;
    private Color color;
    private String brand;

    public Ball(int size, Color color, String brand) {
        this.size = size;
        this.color = color;
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "size=" + size +
                ", color=" + color +
                ", brand='" + brand +
                '}';
    }
}
