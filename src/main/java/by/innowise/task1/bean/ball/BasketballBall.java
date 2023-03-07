package by.innowise.task1.bean.ball;

public class BasketballBall extends Ball {
    public BasketballBall(int size, Color color, String brand) {
        super(size, color, brand);
    }

    @Override
    public String toString() {
        return "BasketballBall{" +
                "size=" + super.getSize() +
                ", color=" + super.getColor() +
                ", brand='" + super.getBrand() +
                '}';
    }
}
