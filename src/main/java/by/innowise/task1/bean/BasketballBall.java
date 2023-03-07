package by.innowise.task1.bean;

public class BasketballBall extends Ball {
    public BasketballBall(int size, Color color) {
        super(size, color);
    }

    @Override
    public String toString() {
        return "BasketballBall{" +
                "size=" + super.getSize() +
                ", color=" + super.getColor() +
                '}';
    }
}
