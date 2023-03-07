package by.innowise.task1.bean.sorting;

import by.innowise.task1.bean.ball.Ball;
import by.innowise.task1.bean.ball.FootballBall;
import by.innowise.task1.bean.ball.VolleyballBall;

import java.util.Comparator;

public class BallClassComparator implements Comparator<Ball> {
    /**
     * Compares its two arguments for order: 1 - VolleyballBall, 2 - FootballBall, 3 - BasketballBall.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     */
    @Override
    public int compare(Ball o1, Ball o2) {
        if (o1.getClass() == o2.getClass()) {
            return 0;
        }

        if (o2 instanceof VolleyballBall) {
            return 1;
        } else if (o2 instanceof FootballBall) {
            if (o1 instanceof VolleyballBall) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return -1;
        }

    }
}
