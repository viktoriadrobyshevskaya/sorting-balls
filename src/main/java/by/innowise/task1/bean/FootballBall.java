package by.innowise.task1.bean;

public class FootballBall extends Ball {
    public FootballBall(int size, Color color) {
        super(size, color);
    }

    @Override
    public String toString() {
        return "FootballBall{" +
                "size=" + super.getSize() +
                ", color=" + super.getColor() +
                '}';
    }
}
