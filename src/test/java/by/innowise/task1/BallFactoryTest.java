package by.innowise.task1;

import by.innowise.task1.bean.Ball;
import by.innowise.task1.bean.BasketballBall;
import by.innowise.task1.bean.Color;
import by.innowise.task1.bean.FootballBall;
import by.innowise.task1.bean.VolleyballBall;
import by.innowise.task1.sorting.SortingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BallFactoryTest {
    private BallFactory ballFactory;

    @BeforeEach
    void setUp() {
        List<Ball> balls = new ArrayList<>();
        balls.add(new VolleyballBall(70, Color.ORANGE));
        balls.add(new BasketballBall(66, Color.BLACK));
        balls.add(new FootballBall(68, Color.BLUE));
        balls.add(new FootballBall(71, Color.ORANGE));
        balls.add(new BasketballBall(72, Color.WHITE));
        balls.add(new BasketballBall(81, Color.YELLOW));
        Collections.shuffle(balls);

        ballFactory = new BallFactory(balls);
    }

    @Test
    @DisplayName("QuickSortingBySize")
    void testQuickSortingBucketComparingBySize() {
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(Comparator.comparingInt(Ball::getSize));

        ballFactory.sortBasket(SortingType.QUICK_SORTING, Comparator.comparing(Ball::getSize));
        List<Ball> sortedBucket = ballFactory.getBucket();

        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @Test
    @DisplayName("QuickSortingByColor")
    void testQuickSortingBucketComparingByColor() {
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(Comparator.comparing(Ball::getColor));

        ballFactory.sortBasket(SortingType.QUICK_SORTING, Comparator.comparing(Ball::getColor));
        List<Ball> sortedBucket = ballFactory.getBucket();

        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @RepeatedTest(5)
    @DisplayName("QuickSortingByClass")
    void testQuickSortingBucketComparingByClass() {
        Comparator<Ball> comparator = new BallClassComparator().thenComparing(Ball::getSize);
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(comparator);

        ballFactory.sortBasket(SortingType.QUICK_SORTING, comparator);
        List<Ball> sortedBucket = ballFactory.getBucket();

        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @Test
    @DisplayName("MergeSortingBySize")
    void testMergeSortingBucketComparingBySize() {
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(Comparator.comparingInt(Ball::getSize));

        ballFactory.sortBasket(SortingType.MERGE_SORTING, Comparator.comparing(Ball::getSize));
        List<Ball> sortedBucket = ballFactory.getBucket();
        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @Test
    @DisplayName("MergeSortingByColor")
    void testMergeSortingBucketComparingByColor() {
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(Comparator.comparing(Ball::getColor));

        ballFactory.sortBasket(SortingType.MERGE_SORTING, Comparator.comparing(Ball::getColor));
        List<Ball> sortedBucket = ballFactory.getBucket();
        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

    @RepeatedTest(5)
    @DisplayName("MergeSortingByClass")
    void testMergeSortingBucketComparingByClass() {
        BallClassComparator comparator = new BallClassComparator();
        List<Ball> expectedBucket = new ArrayList<>(ballFactory.getBucket());
        expectedBucket.sort(comparator);

        ballFactory.sortBasket(SortingType.MERGE_SORTING, comparator);
        List<Ball> sortedBucket = ballFactory.getBucket();
        Assertions.assertEquals(expectedBucket, sortedBucket);
    }

}
