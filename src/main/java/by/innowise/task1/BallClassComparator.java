package by.innowise.task1;

import by.innowise.task1.bean.Ball;
import by.innowise.task1.bean.BasketballBall;
import by.innowise.task1.bean.FootballBall;

import java.util.Comparator;

public class BallClassComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball o1, Ball o2) {
        if (o1.getClass() == o2.getClass()) {
            return 0;
        }

        if (o2 instanceof BasketballBall) {
            return 1;
        } else if (o2 instanceof FootballBall) {
            if (o1 instanceof BasketballBall) {
                return -1;
            } else {
                return 1;
            }
        } else {       // if (o2 instanceof VolleyballBall)
            return -1;
        }
    }
}
