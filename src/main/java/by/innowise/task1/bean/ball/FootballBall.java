package by.innowise.task1.bean.ball;

public class FootballBall extends Ball {
    public FootballBall(int size, Color color, String brand) {
        super(size, color, brand);
    }

    @Override
    public String toString() {
        return "FootballBall{" +
                "size=" + super.getSize() +
                ", color=" + super.getColor() +
                ", brand='" + super.getBrand() +
                '}';
    }
}
