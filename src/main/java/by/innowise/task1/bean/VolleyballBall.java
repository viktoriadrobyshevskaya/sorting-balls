package by.innowise.task1.bean;

public class VolleyballBall extends Ball {
    public VolleyballBall(int size, Color color) {
        super(size, color);
    }

    @Override
    public String toString() {
        return "VolleyballBall{" +
                "size=" + super.getSize() +
                ", color=" + super.getColor() +
                '}';
    }
}
