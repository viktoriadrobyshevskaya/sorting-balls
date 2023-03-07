package by.innowise.task1.bean.ball;

public class VolleyballBall extends Ball {
    public VolleyballBall(int size, Color color, String brand) {
        super(size, color, brand);
    }

    @Override
    public String toString() {
        return "VolleyballBall{" +
                "size=" + super.getSize() +
                ", color=" + super.getColor() +
                ", brand='" + super.getBrand() +
                '}';
    }
}
